package com.example.cleanarchitecture.user.c_adapters;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserDataMapper {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime created_at;

    public UserDataMapper(String username, String password, LocalDateTime created_at) {
        this.name = username;
        this.password = password;
        this.created_at = created_at;
    }

    public UserDataMapper() {}
}
