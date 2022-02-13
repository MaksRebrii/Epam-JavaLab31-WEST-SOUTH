package com.epam.spring.homework3.repository.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Application {
    private int id;
    private User client;
    private User master;
    private Date date;
    private Status completionStatus;
    private String description;
    private BigDecimal price;
    private String review;
}
