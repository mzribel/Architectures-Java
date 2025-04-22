package com.example.cleanarchitecture.user.c_adapters;

import com.example.cleanarchitecture.user.b_application.e_presenter.IUserPresenter;
import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

public class UserResponseFormatter implements IUserPresenter {
    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreated_At());
        response.setCreated_At(responseTime.toString());
        return response;
    }

    @Override
    public UserResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
