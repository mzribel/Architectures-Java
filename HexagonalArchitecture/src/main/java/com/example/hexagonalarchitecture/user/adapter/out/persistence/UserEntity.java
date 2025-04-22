package com.example.hexagonalarchitecture.user.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
public class UserEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    public UserEntity(String username, String password) {
        this.name = username;
        this.password = password;
    }
    public UserEntity() {}

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}