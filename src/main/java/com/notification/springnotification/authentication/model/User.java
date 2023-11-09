package com.notification.springnotification.authentication.model;

import com.notification.springnotification.global.models.AbstractAuditor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author shashi
 * @version 1.0.0
 * @since 11/3/23 10:33 PM
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uk_users_username", columnNames = "user_name")}
)
@AllArgsConstructor
@NoArgsConstructor
public class User  extends AbstractAuditor {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 150)
    private String username;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "allowed_ip", length = 300)
    private String allowedIp;

    // related to spring security user
    @Column(name = "account_non_expired", nullable = false)
    @Builder.Default
    private Boolean accountNonExpired = Boolean.TRUE;

    @Builder.Default
    @Column(name = "account_non_locked", nullable = false)
    private Boolean accountNonLocked = Boolean.TRUE;

    @Builder.Default
    @Column(name = "credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired = Boolean.TRUE;

    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = Boolean.FALSE;

    @Builder.Default
    @Column(name = "allowed_login_failure", nullable = false)
    private Short allowedLoginFailure = 20;

}
