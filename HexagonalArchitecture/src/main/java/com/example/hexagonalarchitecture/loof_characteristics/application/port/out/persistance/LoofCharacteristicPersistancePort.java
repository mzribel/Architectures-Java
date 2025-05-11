package com.example.hexagonalarchitecture.loof_characteristics.application.port.out.persistance;

import java.util.Optional;

public interface LoofCharacteristicPersistancePort<T> {
    T save(T t);
    Optional<T> getByCode(String code);
    boolean existsByCode(String code);
}
