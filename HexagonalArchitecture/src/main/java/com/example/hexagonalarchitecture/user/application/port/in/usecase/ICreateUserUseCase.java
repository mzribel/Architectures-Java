package com.example.hexagonalarchitecture.user.application.port.in.usecase;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonalarchitecture.user.domain.model.User;

public interface ICreateUserUseCase {
    User createUser(CreateUserCommand command) throws Exception;
}
