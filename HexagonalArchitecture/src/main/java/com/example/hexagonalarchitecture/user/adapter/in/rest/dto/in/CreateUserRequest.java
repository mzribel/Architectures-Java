package com.example.hexagonalarchitecture.user.adapter.in.rest.dto.in;

public class CreateUserRequest {
    private String name;

    private String password;

    public CreateUserRequest() {}
    public CreateUserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
