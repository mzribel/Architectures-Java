package com.example.hexagonalarchitecture.user.domain.model;

public interface IUser {
    boolean isPasswordValid();

    String getName();

    String getPassword();
}
