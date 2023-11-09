package com.notification.springnotification.authentication.controller;

import com.notification.springnotification.authentication.dto.UserLoginRequest;
import com.notification.springnotification.authentication.dto.UserRegistrationRequest;
import com.notification.springnotification.authentication.service.AuthService;
import com.notification.springnotification.global.GlobalApiResponse;
import com.notification.springnotification.global.controller.BaseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:45 AM
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController extends BaseController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<GlobalApiResponse> registerUser(@RequestBody @Valid UserRegistrationRequest registrationRequest) {

        return new ResponseEntity<>(successResponse("success",
                authService.registerUser(registrationRequest)),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<GlobalApiResponse> loginUser(@RequestBody @Valid UserLoginRequest userLoginRequest) {

        authService.login(userLoginRequest);
        return new ResponseEntity<>(successResponse("success",
                null),
                HttpStatus.CREATED);
    }

}
