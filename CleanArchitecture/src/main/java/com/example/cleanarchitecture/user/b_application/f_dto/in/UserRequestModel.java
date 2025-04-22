package com.example.cleanarchitecture.user.b_application.f_dto.in;

public class UserRequestModel {
    String name;
    String password;

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public UserRequestModel(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
