package com.group.devops.repository;

import com.group.devops.model.location.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint,Long>{

}
