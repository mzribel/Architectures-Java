package com.example.cleanarchitecture.user.b_application.e_presenter;

import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;

public interface IUserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}
