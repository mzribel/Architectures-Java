package com.example.hexagonalarchitecture.loof_characteristics.infrastructure.configuration;

import com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence.BreedRepositoryImpl;
import com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence.JpaBreedRepository;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.out.persistance.BreedPersistancePort;
import com.example.hexagonalarchitecture.loof_characteristics.application.service.BreedUseCaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatCharacteristicsConfig {

    @Bean
    public BreedPersistancePort breedPersistancePort(
            JpaBreedRepository breedRepository
    ) {
        return new BreedRepositoryImpl(breedRepository);
    }

    @Bean
    public BreedUseCaseService breedUseCaseService(BreedPersistancePort breedPersistancePort) {
        return new BreedUseCaseService(breedPersistancePort);
    }
}