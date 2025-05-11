package com.example.cleanarchitecture.user.b_application.f_dto.in;

import lombok.Getter;

import java.time.LocalDateTime;

public class UserDSRequestModel {
    LocalDateTime created_at;
    String name;
    String password;
    public String getName() { return name; }

    public String getPassword() { return password; }

    public UserDSRequestModel(String name, String password, LocalDateTime created_at) {
        this.name = name;
        this.password = password;
        this.created_at = created_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}
