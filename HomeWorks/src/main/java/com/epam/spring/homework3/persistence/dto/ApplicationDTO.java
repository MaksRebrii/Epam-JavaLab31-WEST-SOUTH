package com.epam.spring.homework3.persistence.dto;

import com.epam.spring.homework3.persistence.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ApplicationDTO {

    private UserDTO client;

    private UserDTO master;

    private Date date;

    private Status status;

    private String description;

    private BigDecimal price;

    private String review;
}
