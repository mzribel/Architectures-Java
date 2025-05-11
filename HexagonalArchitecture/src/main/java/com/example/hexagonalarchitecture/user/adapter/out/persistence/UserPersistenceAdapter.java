package com.example.hexagonalarchitecture.user.adapter.out.persistence;

import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.domain.model.User;
import java.util.Optional;

public class UserPersistenceAdapter implements IUserOutputPort {
    private final IUserRepository userRepository;

    public UserPersistenceAdapter(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity(user.getName(), user.getPassword());
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return new User(savedUserEntity.getId(), savedUserEntity.getName(), savedUserEntity.getPassword());
    }

    @Override
    public Optional<User> getUserByName(String name) {
        UserEntity userEntity = userRepository.getFirstByName(name);
        User user = userEntity != null ? new User(userEntity.getName(), userEntity.getPassword()) : null;
        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsUserByName(String name) {
        return userRepository.existsByName(name);
    }
}
