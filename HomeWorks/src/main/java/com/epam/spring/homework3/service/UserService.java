package com.epam.spring.homework3.service;

import com.epam.spring.homework3.persistence.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    List<UserDTO> listUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    void deleteUser(String email);
}
