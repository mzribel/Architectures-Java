package com.example.hexagonalarchitecture.user.application.port.out;

import com.example.hexagonalarchitecture.user.domain.model.User;
import java.util.Optional;

public interface IUserOutputPort {
    User saveUser(User user);
    Optional<User> getUserByName(String name);
    boolean existsUserByName(String name);
}
