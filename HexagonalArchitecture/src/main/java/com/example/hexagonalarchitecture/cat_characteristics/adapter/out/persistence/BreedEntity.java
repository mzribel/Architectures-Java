package com.example.hexagonalarchitecture.cat_characteristics.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "breeds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BreedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String details;

    public BreedEntity(String code, String name, String details) {
        this.code = code;
        this.name = name;
        this.details = details;
    }
}
