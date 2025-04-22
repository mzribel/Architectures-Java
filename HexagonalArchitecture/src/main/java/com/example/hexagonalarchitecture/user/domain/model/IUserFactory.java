package com.example.hexagonalarchitecture.user.domain.model;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;

public interface IUserFactory {
    IUser createUser(String name, String password);

    IUser fromCreateCommand(CreateUserCommand command);
}
