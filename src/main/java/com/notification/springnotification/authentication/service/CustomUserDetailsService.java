package com.notification.springnotification.authentication.service;

import com.notification.springnotification.authentication.model.User;
import com.notification.springnotification.authentication.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 11:43 PM
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;

    // Here username is actually email : as email is unique
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user by username
        Optional<User> activeUserByUsername = userRepo.findActiveUserByUsername(username);


        return activeUserByUsername.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));


    }
}
