package com.group.devops.controller;

import com.group.devops.model.user.User;
import com.group.devops.model.dto.LoginResponse;
import com.group.devops.model.dto.SignUpRequest;
import com.group.devops.model.dto.LoginRequest;
import com.group.devops.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Controller for handling user-related operations in a DevOps application.
 * Provides endpoints for user login, signup, and retrieving all user details.
 */

@RestController
@RequestMapping("/api")
public class UserController {

    final static Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * Authenticates a user and provides a response token upon successful login.
     *
     * @param request The login request containing user credentials.
     * @return A ResponseEntity containing the login response with a token if successful,
     *         or an error message in case of failure.
     */


    @Operation(summary = "User login", description = "Logs in a user and returns a token")
    @ApiResponse(responseCode = "200", description = "Successfully logged in",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LoginResponse.class)) })
    @ApiResponse(responseCode = "400", description = "Invalid login credentials")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @ParameterObject LoginRequest request) {
        try {
            LoginResponse response = userService.authenticateUser(request);
            LOG.info("Successfully Logged In");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    /**
     * Registers a new user with the provided sign-up details.
     *
     * @param request The sign-up request containing user registration information.
     * @return A ResponseEntity indicating the success or failure of the registration process.
     */

    @Operation(summary = "User registration", description = "Registers a new user")
    @ApiResponse(responseCode = "200", description = "User registered successfully",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "400", description = "Error during registration",
            content = @Content(mediaType = "text/plain"))
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

    /**
     * Retrieves a list of all users in the system. Requires administrator privileges.
     * The method checks for authentication and administrator status before proceeding.
     *
     * @param authHeader Authorization header for user authentication.
     * @param request    Login request to verify if the user has admin privileges.
     * @return A ResponseEntity containing a list of all users or an error message.
     */

    @Operation(summary = "Get all users", description = "Retrieves a list of all users. Requires admin privileges.")
    @ApiResponse(responseCode = "200", description = "List of all users",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class)))
    @ApiResponse(responseCode = "401", description = "Unauthorized access",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "403", description = "Access denied, not an admin",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content(mediaType = "text/plain"))
    @PostMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String authHeader,
                                         @RequestBody @ParameterObject LoginRequest request) {
        if (!userService.authStatus(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }


        if (!userService.isAdmin(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied: User is not an Administrator Role");
        }

        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving users: " + e.getMessage());
        }
    }


}
