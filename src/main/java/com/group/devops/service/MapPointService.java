package com.group.devops.service;

import com.group.devops.model.location.MapPoint;
import com.group.devops.model.user.User;
import com.group.devops.repository.MapPointRepository;
import com.group.devops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapPointService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapPointRepository mapPointRepository;

    public Long saveLocation(double latitude, double longitude, String username, String name, String description) {
        // Find the user by username
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Create a new Location instance
        MapPoint mapPoint = new MapPoint();
        mapPoint.setLat(latitude);
        mapPoint.setLng(longitude);
        mapPoint.setUserName(username);
        mapPoint.setName(name);
        mapPoint.setDescription(description);

        // Save the location to the database
        MapPoint savedMapPoint  = mapPointRepository.save(mapPoint);
        return savedMapPoint.getId();
    }

    public void updateMapPointWithImage(Long mapPointId, String photoUrl) {
        MapPoint mapPoint = mapPointRepository.findById(mapPointId)
                .orElseThrow(() -> new IllegalArgumentException("Map Point not found"));
        mapPoint.setPhotoUrl(photoUrl);
        mapPointRepository.save(mapPoint);
    }

    public List<MapPoint> getAllMapPointsForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return mapPointRepository.findAllByUserName(username);
    }

    // Other methods...
}

