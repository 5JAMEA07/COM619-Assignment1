package com.group.devops.controller;

import com.group.devops.service.FileStorageService;
import com.group.devops.service.MapPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class MapPointController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private MapPointService mapPointService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadLocation(@RequestParam("latitude") double latitude,
                                            @RequestParam("longitude") double longitude,
                                            @RequestParam("image") MultipartFile image,
                                            @RequestParam("username") String username,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description) {
        try {
            String imagePath = fileStorageService.storeFile(image); // Use FileStorageService to save the file
            mapPointService.saveLocation(latitude, longitude, imagePath, username, name, description); // Save location details including imagePath
            return ResponseEntity.ok("Location uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload location: " + e.getMessage());
        }
    }

    // ... other endpoints and methods ...
}

