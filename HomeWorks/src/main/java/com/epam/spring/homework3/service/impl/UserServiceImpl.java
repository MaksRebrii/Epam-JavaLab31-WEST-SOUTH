package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.persistence.dto.UserDTO;
import com.epam.spring.homework3.persistence.entity.User;
import com.epam.spring.homework3.persistence.mapper.UserMapper;
import com.epam.spring.homework3.persistence.repository.UserRepository;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        log.info(this.getClass().getSimpleName() + " getUser method");
        User user = userRepository.getUserByEmail(email);
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    @Override
    public List<UserDTO> listUsers() {
        log.info(this.getClass().getSimpleName() + " listUsers method");
        return UserMapper.INSTANCE.mapUsersToUsersDTO(userRepository.listUsers());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " createUser method");
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " updateUser method");
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info(this.getClass().getSimpleName() + " deleteUser method");
        userRepository.deleteUser(email);
    }
}
