package com.example.hexagonalarchitecture.user.adapter.in.rest.controllers;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.ICreateUserUseCase;
import com.example.hexagonalarchitecture.user.application.port.in.usecase.IGetUserUseCase;
import com.example.hexagonalarchitecture.user.domain.model.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserRestController {
    final ICreateUserUseCase createUserUseCase;
    final IGetUserUseCase getUserUseCase;

    public UserRestController(ICreateUserUseCase createUserUseCase, IGetUserUseCase getUserUseCase)
    {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping("/user")
    IUser create(@RequestBody CreateUserCommand command) throws Exception {
        return createUserUseCase.createUser(command);
    }

    @GetMapping("/user/{name}")
    Optional<IUser> getUser(@PathVariable String name) throws Exception {
        return getUserUseCase.getUserByName(name);
    }
}
