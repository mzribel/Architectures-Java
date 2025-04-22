package com.example.cleanarchitecture.user.b_application.d_gateway;

import com.example.cleanarchitecture.user.b_application.f_dto.in.UserDSRequestModel;

public interface IUserRegisterDSGateway {
    boolean existsByName(String name);
    void save(UserDSRequestModel requestModel);
}
