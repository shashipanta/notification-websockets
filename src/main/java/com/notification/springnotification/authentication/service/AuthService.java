package com.notification.springnotification.authentication.service;

import com.notification.springnotification.authentication.dto.UserLoginRequest;
import com.notification.springnotification.authentication.dto.UserRegistrationRequest;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:52 AM
 */
public interface AuthService {

    Boolean registerUser(UserRegistrationRequest request);

    Long getUserIdFromEmail(String email);

    void login(UserLoginRequest userLoginRequest);




}
