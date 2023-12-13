package com.group.devops.controller;

import com.group.devops.model.location.MapPoint;
import com.group.devops.service.FileStorageService;
import com.group.devops.service.MapPointService;
import com.group.devops.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MapPointController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private MapPointService mapPointService;

    @Autowired
    private UserService userService;

    @PostMapping("/uploadWithoutImage")
    @Operation(summary = "Upload a location without an image", description = "Allows users to upload geographic points without an image")
    @ApiResponse(responseCode = "200", description = "Location uploaded successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Map.class)))
    @ApiResponse(responseCode = "401", description = "Unauthorized access",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content(mediaType = "text/plain"))
    public ResponseEntity<?> uploadLocationWithoutImage( @RequestHeader("Authorization") String authHeader,
                                                         @RequestParam("latitude") @Parameter(description = "Latitude of the location", example = "51.5074") double latitude,
                                                         @RequestParam("longitude") @Parameter(description = "Longitude of the location", example = "0.1278") double longitude,
                                                         @RequestParam("username") @Parameter(description = "Username of the user uploading the location", example = "johndoe123") String username,
                                                         @RequestParam("name") @Parameter(description = "Name of the location", example = "Big Ben") String name,
                                                         @RequestParam("description") @Parameter(description = "Description of the location", example = "Famous London landmark") String description) {
        if (userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }
        try {
            Long mapPointId = mapPointService.saveLocation(latitude, longitude, username, name, description); // No image path
            return ResponseEntity.ok(Map.of("message", "Location without image uploaded successfully", "mapPointId", mapPointId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload location: " + e.getMessage());
        }
    }

    @PostMapping("/updateMapPointWithImage")
    @Operation(summary = "Update a map point with an image", description = "Updates an existing map point with a new image")
    @ApiResponse(responseCode = "200", description = "Map point updated with image successfully",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "401", description = "Unauthorized access",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content(mediaType = "text/plain"))
    public ResponseEntity<?> updateMapPointWithImage(@RequestHeader("Authorization") String authHeader,
                                                     @RequestParam("mapPointId") @Parameter(description = "ID of the map point to be updated", example = "123") Long mapPointId,
                                                     @RequestParam("image") @Parameter(description = "Image file to update the map point with") MultipartFile image) {
        if (userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }
        try {
            String imagePath = fileStorageService.storeFile(image); // Use FileStorageService to save the file
            mapPointService.updateMapPointWithImage(mapPointId, imagePath); // Update map point with the image path
            return ResponseEntity.ok("Map point updated with image successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not update map point: " + e.getMessage());
        }
    }


    @GetMapping("/userMapPoints")
    @Operation(summary = "Get user map points", description = "Retrieves all map points for a specific user")
    @ApiResponse(responseCode = "200", description = "List of map points for the user",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MapPoint.class)))
    @ApiResponse(responseCode = "401", description = "Unauthorized access for user",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "403", description = "Access denied, user is not an administrator",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content(mediaType = "text/plain"))
    public ResponseEntity<?> getUserMapPoints(@RequestHeader("Authorization") String authHeader,
                                              @RequestParam("username") @Parameter(description = "Username of the user whose map points are to be retrieved", example = "johndoe123") String username) {
        if (!userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access for user");
        }

        if (userService.isAdmin(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied: User is not an Administrator");
        }

        try {
            List<MapPoint> mapPoints = mapPointService.getAllMapPointsForUser(username);
            return ResponseEntity.ok(mapPoints);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not retrieve map points: " + e.getMessage());
        }
    }
}

