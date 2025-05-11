package com.example.hexagonalarchitecture.loof_characteristics.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface JpaLoofCharacteristicRepository<T, ID> extends JpaRepository<T, ID> {
    boolean existsByCode(String code);
    Optional<T> findByCode(String code); // optionnel, si tu l'utilises ailleurs
}
