package com.notification.springnotification.authentication.model;

import com.notification.springnotification.authentication.dto.response.UserResponse;
import com.notification.springnotification.globals.auditor.AbstractAuditor;
import com.notification.springnotification.globals.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.util.ClassUtils.isPresent;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_non_expired", nullable = false)
    private Boolean accountNonExpired = false;

    @Column(name = "account_non_locked", nullable = false)
    private Boolean accountNonLocked = false;

    @Column(name = "allowed_ip", length = 300)
    private String allowedIp;

    @Column(name = "allowed_login_failure", nullable = false)
    private Short allowedLoginFailure = 20;

    @Column(name = "credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired = false;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false, length = 150)
    private String userName;

}