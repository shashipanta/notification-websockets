package com.notification.springnotification.authentication.service.impl;

import com.notification.springnotification.authentication.dto.UserLoginRequest;
import com.notification.springnotification.authentication.dto.UserRegistrationRequest;
import com.notification.springnotification.authentication.model.User;
import com.notification.springnotification.authentication.repo.UserRepo;
import com.notification.springnotification.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:54 AM
 */

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Boolean registerUser(UserRegistrationRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepo.save(user);

        return Boolean.TRUE;
    }

    @Override
    public Long getUserIdFromEmail(String email) {
        return userRepo.getUserIdFromEmail(email);
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
        String password = userLoginRequest.getPassword();
        String username = userLoginRequest.getUsername();
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, password));
    }
}
