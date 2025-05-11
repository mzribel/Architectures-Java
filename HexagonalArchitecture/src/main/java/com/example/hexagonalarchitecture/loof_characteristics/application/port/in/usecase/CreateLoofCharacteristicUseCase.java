package com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase;

import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.command.CreateLoofCharacteristicCommand;
import com.example.hexagonalarchitecture.loof_characteristics.domain.model.Breed;

public interface CreateLoofCharacteristicUseCase<T> {
    Breed create(CreateLoofCharacteristicCommand command) throws Exception;
}
