package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;


    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void initMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": initMethod started");
    }

    private void destroyMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": destroyMethod started");
    }
}
