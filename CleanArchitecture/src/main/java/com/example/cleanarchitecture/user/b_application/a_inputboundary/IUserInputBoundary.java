package com.example.cleanarchitecture.user.b_application.a_inputboundary;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserRequestModel;
import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;

public interface IUserInputBoundary {
    UserResponseModel createUser(UserRequestModel requestModel);
}
