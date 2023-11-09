package com.notification.springnotification.global.controller;

import com.notification.springnotification.global.GlobalApiResponse;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/4/23 1:10 AM
 */
public class BaseController {

    private final String SUCCESS = "success";
    private final String FAILURE = "failure";

    public GlobalApiResponse successResponse(String message, Object data) {
        GlobalApiResponse build = GlobalApiResponse
                .builder()
                .statusCode(SUCCESS)
                .data(data)
                .message(message)
                .build();
        return build;


    }
}
