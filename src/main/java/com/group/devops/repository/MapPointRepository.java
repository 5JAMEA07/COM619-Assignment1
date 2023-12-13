package com.group.devops.repository;

import com.group.devops.model.location.MapPoint;
import com.group.devops.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint,Long>{
    @Query("select m from MapPoint m where m.username = :username")
    List<MapPoint> findAllByUserName(@Param("username") String username);
}
