package com.group.devops.repository;

import com.group.devops.model.DevOps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevOpsRepository extends JpaRepository<DevOps, Long> {
    // Additional custom methods if required
}
