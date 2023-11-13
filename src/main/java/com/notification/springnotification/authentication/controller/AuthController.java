package com.notification.springnotification.authentication.controller;

import com.notification.springnotification.authentication.dto.request.UserRegistrationRequest;
import com.notification.springnotification.globals.GlobalApiResponse;
import com.notification.springnotification.globals.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:25 PM
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {

    public ResponseEntity<GlobalApiResponse> registerUser(@RequestBody UserRegistrationRequest request) {

    }


}
