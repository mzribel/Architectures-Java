package com.example.hexagonalarchitecture.user.domain.model;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;

public class UserFactory {
    public User createUser(String name, String password) {
        return new User(name, password);
    }

    public User fromCreateCommand(CreateUserCommand command) {
        return new User(command.name(), command.password());
    }
}
