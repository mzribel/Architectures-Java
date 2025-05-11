package com.example.hexagonalarchitecture.cat_characteristics.adapter.out.persistence;

import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBreedRepository extends JpaRepository<BreedEntity, Long> {
    boolean existsByCode(String code);
}
