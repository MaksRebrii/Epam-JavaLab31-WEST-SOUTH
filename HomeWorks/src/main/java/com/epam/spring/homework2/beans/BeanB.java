package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.MyValidator;
import com.epam.spring.homework2.beans.validator.Visitor;

public class BeanB implements MyValidator {

    private final String name;
    private final int value;

    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private void initMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": initMethod started");
    }

    private void otherInitMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": otherInitMethod started");
    }

    private void destroyMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": destroyMethod started");
    }

    @Override
    public void validate(Visitor visitor) {
        visitor.visitBeanB(this);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
