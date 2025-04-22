package com.example.hexagonalarchitecture.user.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
public class User implements IUser {
    private Long id;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isPasswordValid() {
        return password != null && password.length() > 5;
    }
}
