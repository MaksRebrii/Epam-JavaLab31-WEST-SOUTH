package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.BeanValidatingVisitor;
import com.epam.spring.homework2.beans.validator.SelfValidatingBean;

public class BaseBean implements SelfValidatingBean {

    private final String name;
    private final int value;

    public BaseBean(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void initMethod() {
        System.out.println(getClass().getSimpleName() + ": initMethod started");
    }

    public void destroyMethod() {
        System.out.println(getClass().getSimpleName() + ": destroyMethod started");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
          "name='" + getName() + '\'' +
          ", value=" + getName() +
          '}';
    }

    @Override
    public void accept(final BeanValidatingVisitor beanVisitor) {
        beanVisitor.accept(this);
    }
}
