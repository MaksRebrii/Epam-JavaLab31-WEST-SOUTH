package com.epam.spring.homework3.persistence.repository;

import com.epam.spring.homework3.persistence.entity.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> listUsers();

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}