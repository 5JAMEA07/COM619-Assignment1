package com.group.devops.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Abraham
 */
public class PasswordUtils {

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String hashed){
        return BCrypt.checkpw(password, hashed);
    }

}
