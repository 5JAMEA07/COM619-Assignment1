package com.group.devops.service;

import com.group.devops.model.DevOps;
import com.group.devops.repository.DevOpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DevOpsService {

    @Autowired
    private DevOpsRepository repository;

    public List<DevOps> findAll() {
        return repository.findAll();
    }

    @Transactional
    public DevOps save(DevOps todoItem) {
        return repository.save(todoItem);
    }

    // Other CRUD methods...
}

