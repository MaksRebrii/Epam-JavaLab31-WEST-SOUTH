package com.epam.spring.homework2.beans;

public class BeanB extends BaseBean {

    public BeanB(final String name, final int value) {
        super(name, value);
    }

    public void otherInitMethod() {
        System.out.println(BeanB.class.getSimpleName() + ": otherInitMethod started");
    }
}
