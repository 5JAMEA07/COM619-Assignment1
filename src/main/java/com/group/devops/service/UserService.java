package com.group.devops.service;

import com.group.devops.model.dto.SignUpRequest;
import com.group.devops.model.dto.LoginRequest;
import com.group.devops.model.dto.LoginResponse;
import com.group.devops.model.user.User;
import com.group.devops.repository.UserRepository;
import com.group.devops.utils.JwtUtils;
import com.group.devops.model.user.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * Service for handling user-related operations such as authentication, registration, and role verification.
 */
@Service
public class UserService {

    final static Logger LOG = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Authenticates a user and generates a login response with a JWT token.
     *
     * @param request The login request containing username and password.
     * @return A LoginResponse with a token and user details.
     * @throws IllegalArgumentException If the username or password is invalid.
     */
    public LoginResponse authenticateUser(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && user.isValidPassword(request.getPassword())) {
            LOG.info("User successfully validated");
            String token = jwtUtils.generateToken(user);
            LOG.info("Token generated: " + token);
            return new LoginResponse(token, user);
        } else {
            LOG.error("Invalid username or password");
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    /**
     * Registers a new user in the system.
     *
     * @param request The sign-up request containing the new user's information.
     * @throws RuntimeException If a user with the same username already exists.
     */
    public void signupUser(SignUpRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            User newUser = new User();
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            // Set other properties from request to newUser
            userRepository.save(newUser);
        } else {
            LOG.error("User already exists");
            throw new RuntimeException("User already exists");
        }
    }

    /**
     * Checks if the provided authorization header contains a valid JWT token.
     *
     * @param authHeader The authorization header containing the JWT token.
     * @return True if the token is valid, false otherwise.
     */
    public boolean authStatus(@RequestHeader("Authorization") String authHeader) {
        return JwtUtils.isTokenValid(authHeader);
    }

    /**
     * Checks if a user with the specified username has the role of an administrator.
     *
     * @param username The username to check.
     * @return True if the user is an administrator, false otherwise.
     */
    public boolean isAdmin(String username) {
        User user = userRepository.findByUsername(username);
        return user != null && UserRole.ADMINISTRATOR.equals(user.getUserRole());
    }

    /**
     * Retrieves all users in the system.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Additional methods...
}
