package com.example.hexagonalarchitecture.user.domain.model;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;

public class UserFactory implements IUserFactory {
    public User createUser(String name, String password) {
        return new User(name, password);
    }

    @Override
    public User fromCreateCommand(CreateUserCommand command) {
        return new User(command.name(), command.password());
    }
}
