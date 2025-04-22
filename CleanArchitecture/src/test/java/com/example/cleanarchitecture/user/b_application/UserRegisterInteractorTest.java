package com.example.cleanarchitecture.user.b_application;

import com.example.cleanarchitecture.user.a_entities.User;
import com.example.cleanarchitecture.user.a_entities.UserFactory;
import com.example.cleanarchitecture.user.b_application.b_interactor.UserRegisterInteractor;
import com.example.cleanarchitecture.user.b_application.d_gateway.IUserRegisterDSGateway;
import com.example.cleanarchitecture.user.b_application.e_presenter.IUserPresenter;
import com.example.cleanarchitecture.user.b_application.f_dto.in.UserRequestModel;
import com.example.cleanarchitecture.user.b_application.f_dto.out.UserResponseModel;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserRegisterInteractorTest {
    @Mock
    private IUserRegisterDSGateway userDsGateway;

    @Mock
    private IUserPresenter userPresenter;

    @Mock
    private UserFactory userFactory;

    @InjectMocks
    private UserRegisterInteractor interactor;

    @Test
    void givenRathGateUserAnd123456Password_whenCreate_thenSaveItAndPrepareSuccessView() {
        User user = new User("RathGate", "123456");
        UserRequestModel userRequestModel = new UserRequestModel(user.getName(), user.getPassword());
        when (userDsGateway.existsByName("RathGate")).thenReturn(false);
        when(userFactory.createUser(anyString(), anyString()))
            .thenReturn(user);

        // Act
        interactor.createUser(userRequestModel);

        // Assert
        verify(userDsGateway, times(1)).save(any());
        verify(userPresenter, times(1)).prepareSuccessView(any(UserResponseModel.class));
    }
}
