package com.example.hexagonalarchitecture.user.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    public UserEntity(String username, String password) {
        this.name = username;
        this.password = password;
    }
    public UserEntity() {}

    public UserEntity(Long id, String name, String password) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}