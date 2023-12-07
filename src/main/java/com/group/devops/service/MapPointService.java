package com.group.devops.service;

import com.group.devops.model.location.MapPoint;
import com.group.devops.model.user.User;
import com.group.devops.repository.MapPointRepository;
import com.group.devops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapPointService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapPointRepository mapPointRepository;

    public void saveLocation(double latitude, double longitude, String photoUrl, String username, String name, String description) {
        // Find the user by username
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Create a new Location instance
        MapPoint mapPoint = new MapPoint();
        mapPoint.setLat(latitude);
        mapPoint.setLng(longitude);
        mapPoint.setPhotoUrl(photoUrl);
        mapPoint.setUserName(username);
        mapPoint.setName(name);
        mapPoint.setDescription(description);

        // Save the location to the database
        mapPointRepository.save(mapPoint);
    }

    // Other methods...
}

