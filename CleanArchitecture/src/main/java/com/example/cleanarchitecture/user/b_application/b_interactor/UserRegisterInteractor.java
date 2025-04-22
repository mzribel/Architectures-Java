package com.example.cleanarchitecture.user.b_application.b_interactor;

import com.example.cleanarchitecture.user.a_entities.IUser;
import com.example.cleanarchitecture.user.a_entities.IUserFactory;
import com.example.cleanarchitecture.user.b_application.a_inputboundary.IUserInputBoundary;
import com.example.cleanarchitecture.user.b_application.d_gateway.IUserRegisterDSGateway;
import com.example.cleanarchitecture.user.b_application.e_presenter.IUserPresenter;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserDSRequestModel;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserRequestModel;
import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;

import java.time.LocalDateTime;

public class UserRegisterInteractor implements IUserInputBoundary {
    final IUserRegisterDSGateway userDsGateway;
    final IUserPresenter userPresenter;
    final IUserFactory userFactory;

    // Constructor
    public UserRegisterInteractor(IUserRegisterDSGateway userDsGateway, IUserPresenter userPresenter, IUserFactory userFactory) {
        this.userDsGateway = userDsGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    public UserResponseModel createUser(UserRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        }
        IUser user = userFactory.createUser(requestModel.getName(), requestModel.getPassword());
        if (!user.isPasswordValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        LocalDateTime now = LocalDateTime.now();
        UserDSRequestModel userDsModel = new UserDSRequestModel(user.getName(), user.getPassword(), now);

        userDsGateway.save(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}
