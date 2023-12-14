package com.group.devops.service;

import com.group.devops.model.location.MapPoint;
import com.group.devops.model.user.User;
import com.group.devops.repository.MapPointRepository;
import com.group.devops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling operations related to MapPoints, such as saving and updating map points.
 */
@Service
public class MapPointService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapPointRepository mapPointRepository;

    /**
     * Saves a new location based on provided parameters.
     *
     * @param latitude    The latitude of the location.
     * @param longitude   The longitude of the location.
     * @param username    The username of the user associated with this location.
     * @param name        The name of the location.
     * @param description The description of the location.
     * @return The ID of the saved MapPoint.
     * @throws IllegalArgumentException If the user is not found.
     */
    public Long saveLocation(double latitude, double longitude, String username, String name, String description) {
        // Find the user by username
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Create a new MapPoint instance
        MapPoint mapPoint = new MapPoint();
        mapPoint.setLat(latitude);
        mapPoint.setLng(longitude);
        mapPoint.setUserName(username);
        mapPoint.setName(name);
        mapPoint.setDescription(description);

        // Save the location to the database
        MapPoint savedMapPoint = mapPointRepository.save(mapPoint);
        return savedMapPoint.getId();
    }

    /**
     * Updates a MapPoint with an image URL.
     *
     * @param mapPointId The ID of the MapPoint to be updated.
     * @param photoUrl   The URL of the photo to associate with the MapPoint.
     * @throws IllegalArgumentException If the MapPoint is not found.
     */
    public void updateMapPointWithImage(Long mapPointId, String photoUrl) {
        MapPoint mapPoint = mapPointRepository.findById(mapPointId)
                .orElseThrow(() -> new IllegalArgumentException("Map Point not found"));
        mapPoint.setPhotoUrl(photoUrl);
        mapPointRepository.save(mapPoint);
    }

    /**
     * Retrieves all MapPoints for a specific user.
     *
     * @param username The username of the user whose MapPoints are to be retrieved.
     * @return A list of MapPoints associated with the given username.
     * @throws IllegalArgumentException If the user is not found.
     */
    public List<MapPoint> getAllMapPointsForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return mapPointRepository.findAllByUserName(username);
    }

    // Other methods...
}
