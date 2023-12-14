package com.group.devops.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for handling password hashing and verification.
 */
public class PasswordUtils {

    /**
     * Hashes a password using BCrypt.
     *
     * @param password The password to be hashed.
     * @return The hashed password.
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * Checks a password against its hashed version.
     *
     * @param password The plain text password.
     * @param hashed   The hashed password for comparison.
     * @return True if the password matches the hashed version, false otherwise.
     */
    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
