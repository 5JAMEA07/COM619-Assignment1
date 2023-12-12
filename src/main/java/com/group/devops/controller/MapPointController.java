package com.group.devops.controller;

import com.group.devops.model.location.MapPoint;
import com.group.devops.service.FileStorageService;
import com.group.devops.service.MapPointService;
import com.group.devops.service.UserService;
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
    public ResponseEntity<?> uploadLocationWithoutImage(@RequestHeader("Authorization") String authHeader,
                                                        @RequestParam("latitude") double latitude,
                                                        @RequestParam("longitude") double longitude,
                                                        @RequestParam("username") String username,
                                                        @RequestParam("name") String name,
                                                        @RequestParam("description") String description) {
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
    public ResponseEntity<?> updateMapPointWithImage(@RequestHeader("Authorization") String authHeader,
                                                     @RequestParam("mapPointId") Long mapPointId,
                                                     @RequestParam("image") MultipartFile image) {
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
    public ResponseEntity<?> getUserMapPoints(@RequestHeader("Authorization") String authHeader,
                                              @RequestParam("username") String username) {
        if (!userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
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

