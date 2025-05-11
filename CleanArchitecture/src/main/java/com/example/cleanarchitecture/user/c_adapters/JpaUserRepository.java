package com.example.cleanarchitecture.user.c_adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDataMapper, String> {
    boolean existsByName(String name);
}
