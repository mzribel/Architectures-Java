package com.example.hexagonalarchitecture.loof_characteristics.adapter.in.rest.controllers;

import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.command.CreateLoofCharacteristicCommand;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase.CreateLoofCharacteristicUseCase;
import com.example.hexagonalarchitecture.loof_characteristics.application.port.in.usecase.GetLoofCharacteristicUseCase;
import com.example.hexagonalarchitecture.loof_characteristics.domain.model.Breed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreedController {
    final CreateLoofCharacteristicUseCase<Breed> createUseCase;
    final GetLoofCharacteristicUseCase<Breed> getUseCase;
    public BreedController(CreateLoofCharacteristicUseCase<Breed> createUseCase, GetLoofCharacteristicUseCase<Breed> getUseCase) {
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
    }

    @PostMapping("/breeds")
    public Breed createBreed(@RequestBody CreateLoofCharacteristicCommand command) throws Exception {
        return createUseCase.create(command);
    }
}
