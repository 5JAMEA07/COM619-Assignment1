package com.group.devops.repository;

import com.group.devops.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing and manipulating User entities.
 * Extends JpaRepository to provide common CRUD operations and allows custom query execution.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to be found.
     * @return The User entity associated with the given username, or null if not found.
     */
    @Query("select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);

    /**
     * Finds users by their first and second names.
     *
     * @param firstName The first name of the users to be found.
     * @param secondName The second name of the users to be found.
     * @return A list of User entities that match the given first and second names.
     */
    @Query("select u from User u where u.firstName = :firstName and u.secondName = :secondName")
    List<User> findByNames(@Param("firstName") String firstName, @Param("secondName") String secondName);
}
