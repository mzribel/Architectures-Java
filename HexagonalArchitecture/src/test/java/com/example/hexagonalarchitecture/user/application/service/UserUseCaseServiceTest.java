package com.example.hexagonalarchitecture.user.application.service;

import com.example.hexagonalarchitecture.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.domain.model.User;
import com.example.hexagonalarchitecture.user.domain.model.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserUseCaseServiceTest {
    @Mock
    UserFactory userFactory;
    @Mock
    IUserOutputPort userOutputPort;

    @InjectMocks
    UserUseCaseService userUseCaseService;

    @Test
    void givenRathGateUserAnd123456Password_whenCreateUser_thenReturnUser() throws Exception {
        User user = new User("RathGate", "123456");
        CreateUserCommand createUserCommand = new CreateUserCommand(user.getName(), user.getPassword());

        when (userOutputPort.existsUserByName(user.getName())).thenReturn(false);
        when (userFactory.fromCreateCommand(createUserCommand)).thenReturn(user);

        // Act
        userUseCaseService.createUser(createUserCommand);

        // Assert
        verify(userOutputPort, times(1)).saveUser(any(User.class));
    }
}
