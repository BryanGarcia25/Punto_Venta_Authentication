package com.smartposlocal.mx.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private int failedLoginAttemps;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordExpireDate;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
}
