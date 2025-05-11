package com.example.hexagonalarchitecture.cat_characteristics.application.port.in.usecase;

import com.example.hexagonalarchitecture.cat_characteristics.application.port.in.command.CreateBreedCommand;
import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;

public interface CreateBreedUseCase {
    Breed createBreed(CreateBreedCommand command) throws Exception;

}
