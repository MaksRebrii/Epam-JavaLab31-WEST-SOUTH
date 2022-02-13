package com.epam.spring.homework3.repository.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class User {

    private int id;

    private Role role;

    private String name;

    private String surname;

    private String email;

    private String password;

    private BigDecimal account;
}
