package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.MyValidator;
import com.epam.spring.homework2.beans.validator.Visitor;

public class BeanD implements MyValidator {

    private final String name;
    private final int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private void initMethod() {
        System.out.println(BeanD.class.getSimpleName() + ": initMethod started");
    }

    private void destroyMethod() {
        System.out.println(BeanD.class.getSimpleName() + ": destroyMethod started");
    }

    @Override
    public void validate(Visitor visitor) {
        visitor.visitBeanD(this);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
