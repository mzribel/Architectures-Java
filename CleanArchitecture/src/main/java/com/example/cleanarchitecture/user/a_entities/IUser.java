package com.example.cleanarchitecture.user.a_entities;

public interface IUser {
    boolean isPasswordValid();

    String getName();

    String getPassword();
}
