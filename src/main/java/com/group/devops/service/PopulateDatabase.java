package com.group.devops.service;

import com.group.devops.model.user.User;
import com.group.devops.model.user.UserRole;
import com.group.devops.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PopulateDatabase {

    private static final Logger LOG = LogManager.getLogger(PopulateDatabase.class);

    private static final String DEFAULT_ADMIN_USERNAME = "globaladmin";
    private static final String DEFAULT_ADMIN_PASSWORD = "globaladmin";

    private static final String DEFAULT_USER_PASSWORD = "user1234";
    private static final String DEFAULT_USER_USERNAME = "user1234";

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initDatabase() {
        LOG.debug("initialising database with startup values");


        User adminUser = new User();
        adminUser.setUsername(DEFAULT_ADMIN_USERNAME);
        adminUser.setFirstName("default administrator");
        adminUser.setPassword(DEFAULT_ADMIN_PASSWORD);
        adminUser.setUserRole(UserRole.ADMINISTRATOR);

        User users = userRepository.findByUsername(DEFAULT_ADMIN_USERNAME);
        LOG.info(users);
        if (users == null) {
            userRepository.save(adminUser);
            LOG.info("creating new default admin user:" + adminUser);
        } else {
            LOG.info("default admin user already exists. Not creating new :" + adminUser);
        }

        User defaultUser = new User();
        defaultUser.setUsername(DEFAULT_USER_USERNAME);
        defaultUser.setFirstName("default user");
        defaultUser.setPassword(DEFAULT_USER_PASSWORD);
        defaultUser.setUserRole(UserRole.CUSTOMER);

        users = userRepository.findByUsername(DEFAULT_USER_USERNAME);
        if (users == null) {
            userRepository.save(defaultUser);
            LOG.info("creating new default user:" + defaultUser);
        } else {
            LOG.info("defaultuser already exists. Not creating new :" + defaultUser);
        }

        LOG.debug("database initialised");
    }
}
