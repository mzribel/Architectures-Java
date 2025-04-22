package com.example.cleanarchitecture.user.a_entities;

public class UserFactory implements IUserFactory {
    public User createUser(String name, String password) {
        return new User(name, password);
    }
}
