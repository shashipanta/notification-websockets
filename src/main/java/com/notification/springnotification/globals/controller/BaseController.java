package com.notification.springnotification.globals.controller;

import com.notification.springnotification.globals.GlobalApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:28 PM
 */
public class BaseController {

    private static final String FAILURE = "FAILURE";

    private static final String SUCCESS = "SUCCESS";

    public GlobalApiResponse successResponse(String message, Object data) {
        return GlobalApiResponse.builder()
                .messageCode(SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public GlobalApiResponse failureResponse(String message, Object data) {
        return GlobalApiResponse.builder()
                .messageCode(FAILURE)
                .data(data)
                .message(message)
                .build();
    }
}
