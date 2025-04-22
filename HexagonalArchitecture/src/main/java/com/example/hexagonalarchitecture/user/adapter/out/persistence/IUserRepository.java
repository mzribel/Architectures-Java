package com.example.hexagonalarchitecture.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
    UserEntity getFirstByName(String name);
}
