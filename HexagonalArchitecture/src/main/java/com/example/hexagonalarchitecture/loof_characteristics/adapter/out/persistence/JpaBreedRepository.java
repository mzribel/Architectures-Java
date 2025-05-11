package com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBreedRepository extends JpaLoofCharacteristicRepository<BreedEntity, Long> {
    boolean existsByCode(String code);
    BreedEntity getByCode(String code);
}
