package com.notification.springnotification.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 12:47 AM
 */
@Getter
@Setter
public class UserRegistrationRequest {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "Email must be well formed")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

}
