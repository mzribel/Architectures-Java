package com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase;

import java.util.Optional;

public interface GetLoofCharacteristicUseCase<T> {
    Optional<T> getByCode(String code);
}
