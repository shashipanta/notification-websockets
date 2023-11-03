package com.notification.springnotification.global.models;

import com.notification.springnotification.global.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 10:35 PM
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditor {


    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private Integer createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private Timestamp lastModifiedDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = Boolean.TRUE;

    @Column(name = "status", nullable = false)
    private Status status = Status.APPROVED;
}
