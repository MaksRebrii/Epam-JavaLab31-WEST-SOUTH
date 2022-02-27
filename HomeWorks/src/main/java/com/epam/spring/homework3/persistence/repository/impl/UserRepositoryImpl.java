package com.epam.spring.homework3.persistence.repository.impl;

import com.epam.spring.homework3.persistence.entity.User;
import com.epam.spring.homework3.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        log.info(this.getClass().getSimpleName() + "get user with email {}", email);
        return userList.stream()
                .filter(user -> user.getEmail()
                        .equals(email)).findFirst()
                .orElseThrow(() -> new RuntimeException("User in not found"));
    }

    @Override
    public List<User> listUsers() {
        log.info(this.getClass().getSimpleName() + "get all users");
        return new ArrayList<>(userList);
    }

    @Override
    public User createUser(User user) {
        log.info(this.getClass().getSimpleName() + "create new user {}", user);
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        log.info(this.getClass().getSimpleName() + "update user with email {}", email);
        boolean isDeleted = userList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new RuntimeException("User is not found");
        }
        return null;
    }

    @Override
    public void deleteUser(String email) {
        log.info(this.getClass().getSimpleName() + "delete user by email{}", email);
        userList.removeIf(user -> user.getEmail().equals(email));
    }
}
