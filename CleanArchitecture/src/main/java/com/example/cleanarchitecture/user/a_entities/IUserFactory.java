package com.example.cleanarchitecture.user.a_entities;

public interface IUserFactory {
    IUser createUser(String name, String password);
}
