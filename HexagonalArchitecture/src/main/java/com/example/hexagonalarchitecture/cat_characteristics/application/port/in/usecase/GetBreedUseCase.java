package com.example.hexagonalarchitecture.cat_characteristics.application.port.in.usecase;


import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;
import java.util.Optional;

public interface GetBreedUseCase {
    Optional<Breed> getBreedByCode(String code);
}
