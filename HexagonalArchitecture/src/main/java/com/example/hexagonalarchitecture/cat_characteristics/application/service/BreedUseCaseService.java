package com.example.hexagonalarchitecture.cat_characteristics.application.service;

import com.example.hexagonalarchitecture.cat_characteristics.application.port.in.command.CreateBreedCommand;
import com.example.hexagonalarchitecture.cat_characteristics.application.port.in.usecase.CreateBreedUseCase;
import com.example.hexagonalarchitecture.cat_characteristics.application.port.in.usecase.GetBreedUseCase;
import com.example.hexagonalarchitecture.cat_characteristics.application.port.out.BreedPersistancePort;
import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;

import java.util.Optional;

public class BreedUseCaseService implements
        CreateBreedUseCase,
        GetBreedUseCase
{
    private final BreedPersistancePort breedPersistancePort;

    public BreedUseCaseService(BreedPersistancePort breedPersistancePort) {
        this.breedPersistancePort = breedPersistancePort;
    }

    @Override
    public Breed createBreed(CreateBreedCommand command) throws Exception {
        if (breedPersistancePort.existsBreedByCode(command.code())) {
            throw new Exception("Breed already exists");
        }
        Breed breeder = new Breed(command.code(), command.name(), command.details());
        return breedPersistancePort.saveBreed(breeder);
    }

    @Override
    public Optional<Breed> getBreedByCode(String code) {
        return breedPersistancePort.getBreedByCode(code);
    }
}
