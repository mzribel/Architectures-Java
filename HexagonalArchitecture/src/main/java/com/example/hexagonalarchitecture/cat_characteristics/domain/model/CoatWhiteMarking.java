package com.example.hexagonalarchitecture.cat_characteristics.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoatWhiteMarking {
    private Long id;
    private String code;
    private String name;
    private String details;

    public CoatWhiteMarking(String code, String name, String details) {
        this.code = code;
        this.name = name;
        this.details = details;
    }
}