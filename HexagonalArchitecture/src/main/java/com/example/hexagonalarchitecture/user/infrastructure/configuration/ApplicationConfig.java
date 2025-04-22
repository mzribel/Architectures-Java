package com.example.hexagonalarchitecture.user.infrastructure.configuration;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.IUserRepository;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.UserPersistenceAdapter;
import com.example.hexagonalarchitecture.user.application.port.out.IUserOutputPort;
import com.example.hexagonalarchitecture.user.application.service.UserUseCaseService;
import com.example.hexagonalarchitecture.user.domain.model.IUserFactory;
import com.example.hexagonalarchitecture.user.domain.model.UserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public IUserOutputPort userOutputPort(
            IUserRepository userRepository
    ) {
        return new UserPersistenceAdapter(userRepository);
    }


    @Bean
    public IUserFactory userFactory() {
        return new UserFactory();
    }

    @Bean
    public UserUseCaseService userUseCaseService(IUserOutputPort userOutputPort, IUserFactory userFactory) {
        return new UserUseCaseService(userOutputPort, userFactory);
    }
}