package com.example.cleanarchitecture.user.c_adapters;

import com.example.cleanarchitecture.user.b_application.a_inputboundary.IUserInputBoundary;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserRequestModel;
import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {
    final IUserInputBoundary userInputBoundary;

    @Autowired
    public UserRegisterController(IUserInputBoundary userInputBoundary) {
        this.userInputBoundary = userInputBoundary;
    }

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel userRequestModel) {
        return userInputBoundary.createUser(userRequestModel);
    }
}
