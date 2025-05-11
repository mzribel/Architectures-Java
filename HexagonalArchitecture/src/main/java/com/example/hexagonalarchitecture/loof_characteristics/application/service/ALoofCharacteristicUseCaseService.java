package com.example.hexagonalarchitecture.loof_characteristics.application.service;

import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.command.CreateLoofCharacteristicCommand;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.out.persistance.LoofCharacteristicPersistancePort;
import com.example.hexagonalarchitecture.loof_characteristics.domain.model.ALoofCharacteristic;

import java.util.Optional;

public abstract class ALoofCharacteristicUseCaseService<
        T extends ALoofCharacteristic,
        C extends CreateLoofCharacteristicCommand,
        P extends LoofCharacteristicPersistancePort<T>>
{
    private final P persistancePort;

    public ALoofCharacteristicUseCaseService(P persistancePort) {
        this.persistancePort = persistancePort;
    }

    public T create(C command) throws Exception {
        if (persistancePort.existsByCode(command.code())) {
            throw new Exception("Breed already exists");
        }
        T model = mapToModel(command);
        return persistancePort.save(model);
    }

    public Optional<T> getByCode(String code) {
        return persistancePort.getByCode(code);
    }

    protected abstract T mapToModel(C command);
}
