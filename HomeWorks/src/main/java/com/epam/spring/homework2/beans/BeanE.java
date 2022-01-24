package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {

    private String name;
    private int value;

    @PostConstruct
    public void postConstructMethod() {
        System.out.println(BeanE.class.getSimpleName() + ": postConstruct started");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println(BeanE.class.getSimpleName() + ": preDestroy started");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
