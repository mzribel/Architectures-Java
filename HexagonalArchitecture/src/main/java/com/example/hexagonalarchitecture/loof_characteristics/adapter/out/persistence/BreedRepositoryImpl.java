package com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence;

import com.example.hexagonalarchitecture.loof_characteristics.application.port.out.persistance.BreedPersistancePort;
import com.example.hexagonalarchitecture.loof_characteristics.domain.model.Breed;

import java.util.Optional;

public class BreedRepositoryImpl implements BreedPersistancePort {

    private final JpaBreedRepository breedRepository;

    public BreedRepositoryImpl(JpaBreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Breed save(Breed breed) {
        BreedEntity breedEntity = new BreedEntity(breed.getCode(), breed.getName(), breed.getDetails());
        BreedEntity savedBreedEntity = breedRepository.save(breedEntity);
        return new Breed(savedBreedEntity.getId(), savedBreedEntity.getCode(), savedBreedEntity.getName(), savedBreedEntity.getDetails());
    }

    @Override
    public Optional<Breed> getByCode(String code) {
        return Optional.empty();
    }

    @Override
    public boolean existsByCode(String code) {
        return breedRepository.existsByCode(code);
    }
}
