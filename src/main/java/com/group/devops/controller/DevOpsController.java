package com.group.devops.controller;

import com.group.devops.model.DevOps;
import com.group.devops.service.DevOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DevOpsController {

    @Autowired
    private DevOpsService devOpsService;

    @GetMapping
    @RequestMapping("/getAll")
    public List<DevOps> getAllTodos() {
        return devOpsService.findAll();
    }

    @PostMapping
    public DevOps createTodo(@RequestBody DevOps todoItem) {
        return devOpsService.save(todoItem);
    }

    // Additional methods for PUT, DELETE...
}
