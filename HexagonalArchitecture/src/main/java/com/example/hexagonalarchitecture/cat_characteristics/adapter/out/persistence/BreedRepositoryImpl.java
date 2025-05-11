package com.example.hexagonalarchitecture.cat_characteristics.adapter.out.persistence;

import com.example.hexagonalarchitecture.cat_characteristics.application.port.out.BreedPersistancePort;
import com.example.hexagonalarchitecture.cat_characteristics.domain.model.Breed;

import java.util.Optional;

public class BreedRepositoryImpl implements BreedPersistancePort {

    private final JpaBreedRepository breedRepository;

    public BreedRepositoryImpl(JpaBreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Breed saveBreed(Breed breed) {
        BreedEntity breedEntity = new BreedEntity(breed.getCode(), breed.getName(), breed.getDetails());
        BreedEntity savedBreedEntity = breedRepository.save(breedEntity);
        return new Breed(savedBreedEntity.getId(), savedBreedEntity.getCode(), savedBreedEntity.getName(), savedBreedEntity.getDetails());
    }

    @Override
    public Optional<Breed> getBreedByCode(String code) {
        return Optional.empty();
    }

    @Override
    public boolean existsBreedByCode(String code) {
        return breedRepository.existsByCode(code);
    }
}
