package com.group.devops.repository;

import java.util.List;
import com.group.devops.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query("select u from User u where u.firstName = :firstName and u.secondName = :secondName")
    List<User> findByNames(@Param("firstName") String firstName, @Param("secondName") String secondName);

}

