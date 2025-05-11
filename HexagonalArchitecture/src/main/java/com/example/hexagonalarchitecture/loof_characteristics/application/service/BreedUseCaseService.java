package com.example.hexagonalarchitecture.loof_characteristics.application.service;

import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.command.CreateLoofCharacteristicCommand;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase.CreateLoofCharacteristicUseCase;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase.GetLoofCharacteristicUseCase;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.out.persistance.BreedPersistancePort;
import com.example.hexagonalarchitecture.loof_characteristics.domain.model.Breed;

import java.util.Optional;

public class BreedUseCaseService extends ALoofCharacteristicUseCaseService<
            Breed,
            CreateLoofCharacteristicCommand,
            BreedPersistancePort>
        implements
            CreateLoofCharacteristicUseCase<Breed>,
            GetLoofCharacteristicUseCase<Breed>
{

    public BreedUseCaseService(BreedPersistancePort breedPersistancePort) {
        super(breedPersistancePort);
    }

    @Override
    protected Breed mapToModel(CreateLoofCharacteristicCommand command) {
        return new Breed(command.code(), command.name(), command.details());
    }
}
