package com.example.cleanarchitecture.user.c_adapters;

import com.example.cleanarchitecture.user.b_application.d_gateway.IUserRegisterDSGateway;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserDSRequestModel;

public class JpaUser implements IUserRegisterDSGateway {

    final JpaUserRepository userRepository;

    public JpaUser(final JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByName(String name) {
        return userRepository.existsById(name);
    }

    @Override
    public void save(UserDSRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), requestModel.getCreated_at());
        userRepository.save(accountDataMapper);
    }
}
