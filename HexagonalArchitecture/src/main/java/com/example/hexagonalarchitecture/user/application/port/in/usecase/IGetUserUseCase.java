package com.example.hexagonalarchitecture.user.application.port.in.usecase;

import com.example.hexagonalarchitecture.user.domain.model.User;

import java.util.Optional;

public interface IGetUserUseCase {
    Optional<User> getUserByName(String name);
}
