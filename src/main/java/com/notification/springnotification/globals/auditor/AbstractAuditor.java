package com.notification.springnotification.globals.auditor;

import com.notification.springnotification.globals.enums.Status;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/14/23 1:12 AM
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditor {

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private Long createdBy;
    @Column(name = "created_on", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdOn;
    @Column(name = "last_updated_by", nullable = false)
    @LastModifiedBy
    private Long lastUpdatedBy;
    @Column(name = "updated_on", nullable = false)
    @LastModifiedDate
    private Timestamp updatedOn;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.APPROVED;

}
