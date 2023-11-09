package com.notification.springnotification.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/9/23 1:35 AM
 */

@Setter
@Getter
@Builder
public class ProductRequest {

    @NotBlank(message = "product name cannot be blank")
    private String name;

    @NotBlank(message = "product nepali name cannot be blank")
    private String nameNp;

    @NotNull(message = "cannot be null")
    private Integer price;

}
