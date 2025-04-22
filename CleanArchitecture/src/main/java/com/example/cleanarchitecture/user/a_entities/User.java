package com.example.cleanarchitecture.user.a_entities;

public class User implements IUser {
    String name;
    String password;

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
