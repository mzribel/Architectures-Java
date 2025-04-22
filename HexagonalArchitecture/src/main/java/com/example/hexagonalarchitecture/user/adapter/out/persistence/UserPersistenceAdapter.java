package com.example.hexagonalarchitecture.user.adapter.out.persistence;

import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.domain.model.IUser;
import com.example.hexagonalarchitecture.user.domain.model.User;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UserPersistenceAdapter implements IUserOutputPort {
    private final IUserRepository userRepository;

    public UserPersistenceAdapter(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void saveUser(IUser user) {
        UserEntity userEntity = new UserEntity(user.getName(), user.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public Optional<IUser> getUserByName(String name) {
        UserEntity userEntity = userRepository.getFirstByName(name);
        IUser user = userEntity != null ? new User(userEntity.getName(), userEntity.getPassword()) : null;
        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsUserByName(String name) {
        return userRepository.existsById(name);
    }
}
