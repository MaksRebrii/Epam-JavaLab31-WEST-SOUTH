package com.epam.spring.homework3.persistence.dto;

import com.epam.spring.homework3.persistence.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDTO {

    private Role role;

    private String name;

    private String surname;

    private String email;

    private BigDecimal account;
}
