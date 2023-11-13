package com.notification.springnotification.authentication.service.impl;

import com.notification.springnotification.authentication.dto.request.UserRegistrationRequest;
import com.notification.springnotification.authentication.dto.request.UserUpdateRequest;
import com.notification.springnotification.authentication.dto.response.UserResponse;
import com.notification.springnotification.authentication.repo.UserRepository;
import com.notification.springnotification.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:51 PM
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public Long create(UserRegistrationRequest request) {
        return null;
    }

    @Override
    public Long update(UserUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public void delete(Long userId) {
        // Todo: check and throw exception if id not found
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse getSingle(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> getAll() {
        return null;
    }
}
