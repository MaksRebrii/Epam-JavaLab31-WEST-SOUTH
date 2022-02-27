package com.epam.spring.homework3.persistence.mapper;

import com.epam.spring.homework3.persistence.dto.UserDTO;
import com.epam.spring.homework3.persistence.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapUserToUserDTO(User user);

    User mapUserDTOToUser(UserDTO userDTO);

    List<UserDTO> mapUsersToUsersDTO(List<User> users);
}
