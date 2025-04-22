package com.example.cleanarchitecture.user.b_application.f_dto.out;

public class UserResponseModel {
    String name;
    String created_at;

    public String getCreated_At() { return created_at; }
    public void setCreated_At(String created_at) { this.created_at = created_at; }

    public UserResponseModel(String name, String created_at) {
        this.name = name;
        this.created_at = created_at;
    }
}
