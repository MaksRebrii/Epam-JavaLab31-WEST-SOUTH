package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD {

    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
    private int value;

    private void initMethod() {
        System.out.println(BeanD.class.getSimpleName() + ": initMethod started");
    }

    private void destroyMethod() {
        System.out.println(BeanD.class.getSimpleName() + ": destroyMethod started");
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
