package com.group.devops.service;

import com.group.devops.model.dto.SignUpRequest;
import com.group.devops.model.dto.LoginRequest;
import com.group.devops.model.dto.LoginResponse;
import com.group.devops.model.user.User;
import com.group.devops.repository.UserRepository;
import com.group.devops.utils.JwtUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final static Logger LOG = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public LoginResponse authenticateUser(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && user.isValidPassword(request.getPassword())) {
            LOG.info("User successfully validated");
            String token = jwtUtils.generateToken(user);
            LOG.info("Token generated " + token);
            return new LoginResponse(token, user);
        } else {
            LOG.error("Invalid username or password");
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public void signupUser(SignUpRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            User newUser = new User();
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            // Set other properties from request to newUser
            userRepository.save(newUser);
        }else {
            LOG.error("Invalid username or password");
            throw new RuntimeException("user already exist");
        }

    }

}
