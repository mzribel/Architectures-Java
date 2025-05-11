package com.example.hexagonalarchitecture.cat_characteristics.application.port.out;

import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;

import java.util.Optional;

public interface BreedPersistancePort {
    Breed saveBreed(Breed breed);
    Optional<Breed> getBreedByCode(String code);
    boolean existsBreedByCode(String code);
}
