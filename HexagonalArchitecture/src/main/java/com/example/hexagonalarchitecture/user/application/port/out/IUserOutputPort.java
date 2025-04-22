package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.model.IUser;

import java.util.Optional;

public interface IUserOutputPort {
    void saveUser(IUser user);
    Optional<IUser> getUserByName(String name);

    boolean existsUserByName(String name);
}
