package com.notification.springnotification.authentication.repo;

import com.notification.springnotification.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 11:47 PM
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM USERS u WHERE u.email = ?1 AND u.is_active = true")
    Optional<User> findActiveUserByUsername(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM USERS u WHERE u.email = ?1 AND u.is_active = true")
    Long getUserIdFromEmail(String email);


}
