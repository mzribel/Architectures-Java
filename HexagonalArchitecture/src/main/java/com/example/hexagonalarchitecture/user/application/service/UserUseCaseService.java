package com.example.hexagonalarchitecture.user.application.service;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.ICreateUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.IGetUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.domain.model.IUser;
import com.example.hexagonalarchitecture.user.domain.model.IUserFactory;

import java.util.Optional;

public class UserUseCaseService implements ICreateUserUseCase, IGetUserUseCase {
    private final IUserOutputPort userOutputPort;
    private final IUserFactory userFactory;

    public UserUseCaseService(IUserOutputPort userOutputPort, IUserFactory userFactory) {
        this.userOutputPort = userOutputPort;
        this.userFactory = userFactory;

    }
    @Override
    public IUser createUser(CreateUserCommand command) throws Exception {
        if (userOutputPort.existsUserByName(command.name())) {
            throw new Exception("User already exists");
        }

        IUser user = userFactory.fromCreateCommand(command);
        if (!user.isPasswordValid()) {
            throw new Exception("Password is incorrect");
        }
        
        userOutputPort.saveUser(user);
        return user;
    }

    @Override
    public Optional<IUser> getUserByName(String name) {
        return userOutputPort.getUserByName(name);
    }
}
