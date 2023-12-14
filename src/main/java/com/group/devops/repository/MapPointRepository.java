package com.group.devops.repository;

import com.group.devops.model.location.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing and manipulating MapPoint entities.
 * Extends JpaRepository for common CRUD operations and custom query execution.
 */
@Repository
public interface MapPointRepository extends JpaRepository<MapPoint, Long> {

    /**
     * Retrieves all MapPoint entities associated with a specific username.
     *
     * @param username The username to search for associated map points.
     * @return A list of MapPoint entities related to the given username.
     */
    @Query("select m from MapPoint m where m.username = :username")
    List<MapPoint> findAllByUserName(@Param("username") String username);
}
