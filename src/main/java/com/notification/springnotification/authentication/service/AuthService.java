package com.notification.springnotification.authentication.service;

import com.notification.springnotification.authentication.dto.request.UserRegistrationRequest;
import com.notification.springnotification.authentication.dto.request.UserUpdateRequest;
import com.notification.springnotification.authentication.dto.response.UserResponse;

import java.util.List;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:45 PM
 */
public interface AuthService {

    Long create(UserRegistrationRequest request);

    Long update(UserUpdateRequest updateRequest);

    void delete(Long userId);

    UserResponse getSingle(Long id);

    List<UserResponse> getAll();
}
