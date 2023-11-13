package com.notification.springnotification.globals.enums;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/13/23 11:14 PM
 */
public enum Status {

    APPROVED("APPROVED", "NEPALI-APPROVED"),
    UNDER_APPROVAL("UNDER_APPROVAL", "NEPALI-UNDER_APPROVAL"),
    REJECTED("REJECTED", "NEPALI-REJECTED");


    private String statusNameEn;
    private String statusNameNp;

    Status(String statusNameEn, String statusNameNp) {
        this.statusNameEn = statusNameEn;
        this.statusNameNp = statusNameNp;
    }
}
