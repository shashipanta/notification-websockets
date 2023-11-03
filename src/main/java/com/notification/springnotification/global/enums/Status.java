package com.notification.springnotification.global.enums;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 11:04 PM
 */
public enum Status {

    UNDER_APPROVAL("UNDER APPROVAL"),
    APPROVED("APPROVED");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }
}
