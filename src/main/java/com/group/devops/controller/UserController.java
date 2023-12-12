package com.group.devops.controller;

import com.group.devops.model.user.User;
import com.group.devops.model.dto.LoginResponse;
import com.group.devops.model.dto.SignUpRequest;
import com.group.devops.model.dto.LoginRequest;
import com.group.devops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    final static Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = userService.authenticateUser(request);
            LOG.info("Successfully Logged In");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        try {
            userService.signupUser(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            LOG.error("Error during registration: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error during registration: " + e.getMessage());
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String authHeader,
                                         @RequestParam("username") String username) {
        if (userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }


        if (userService.isAdmin(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied: User is not an Administrator");
        }

        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving users: " + e.getMessage());
        }
    }


}
