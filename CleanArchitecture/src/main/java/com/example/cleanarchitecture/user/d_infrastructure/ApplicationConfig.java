package com.example.cleanarchitecture.user.d_infrastructure;

import com.example.cleanarchitecture.user.a_entities.IUserFactory;
import com.example.cleanarchitecture.user.a_entities.UserFactory;
import com.example.cleanarchitecture.user.b_application.a_inputboundary.IUserInputBoundary;
import com.example.cleanarchitecture.user.b_application.b_interactor.UserRegisterInteractor;
import com.example.cleanarchitecture.user.b_application.d_gateway.IUserRegisterDSGateway;
import com.example.cleanarchitecture.user.b_application.e_presenter.IUserPresenter;
import com.example.cleanarchitecture.user.c_adapters.JpaUser;
import com.example.cleanarchitecture.user.c_adapters.JpaUserRepository;
import com.example.cleanarchitecture.user.c_adapters.UserResponseFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public IUserInputBoundary userInputBoundary(
            IUserRegisterDSGateway userDsGateway,
            IUserPresenter userPresenter,
            IUserFactory userFactory
    ) {
        return new UserRegisterInteractor(userDsGateway, userPresenter, userFactory);
    }

    @Bean
    public IUserRegisterDSGateway userRegisterDSGateway(JpaUserRepository repository) {
        return new JpaUser(repository);  // Use your actual JPA repository or stub
    }

    @Bean
    public IUserPresenter userPresenter() {
        return new UserResponseFormatter(); // Use your actual presenter or stub
    }

    @Bean
    public IUserFactory userFactory() {
        return new UserFactory(); // Your actual factory class
    }
}