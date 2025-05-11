package com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "breeds")
@NoArgsConstructor
public class BreedEntity extends LoofCharacteristicEntity {
    public BreedEntity(String code, String name, String details) {
        super(code, name, details);
    }
    public BreedEntity(Long id, String code, String name, String details) {
        super(id, code, name, details);
    }

}
