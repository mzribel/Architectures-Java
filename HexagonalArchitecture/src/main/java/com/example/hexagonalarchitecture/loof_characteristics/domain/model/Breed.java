package com.example.hexagonalarchitecture.loof_characteristics.domain.model;

public class Breed extends ALoofCharacteristic {
    public Breed(String code, String name, String details) {
        super(code, name, details);
    }

    public Breed(Long id, String code, String name, String details) {
        super(id, code, name, details);
    }
}

