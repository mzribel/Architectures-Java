package com.example.hexagonalarchitecture.user.domain.model;

import lombok.*;

@Builder
public class User {
    private Long id;
    private String name;
    private String password;

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User(String name, String password) {
       this(null, name, password);
    }

    public boolean isPasswordValid() {
        return password != null && password.length() > 5;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
}
