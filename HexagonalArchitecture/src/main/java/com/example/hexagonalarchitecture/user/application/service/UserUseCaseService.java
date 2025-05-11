package com.example.hexagonalarchitecture.user.application.service;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.UserEntity;
import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.ICreateUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.IGetUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.domain.model.User;
import com.example.hexagonalarchitecture.user.domain.model.UserFactory;

import java.util.Optional;

public class UserUseCaseService implements ICreateUserUseCase, IGetUserUseCase {
    private final IUserOutputPort userOutputPort;
    private final UserFactory userFactory;

    public UserUseCaseService(IUserOutputPort userOutputPort, UserFactory userFactory) {
        this.userOutputPort = userOutputPort;
        this.userFactory = userFactory;

    }
    @Override
    public User createUser(CreateUserCommand command) throws Exception {
        if (userOutputPort.existsUserByName(command.name())) {
            throw new Exception("User already exists");
        }

        User user = userFactory.fromCreateCommand(command);
        if (!user.isPasswordValid()) {
            throw new Exception("Password is incorrect");
        }
        
        return userOutputPort.saveUser(user);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userOutputPort.getUserByName(name);
    }
}
