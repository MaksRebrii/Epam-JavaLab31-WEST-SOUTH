package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean {

    private String name;
    private int value;

    @Override
    public void destroy() {
        System.out.println(BeanA.class.getSimpleName() + ": DisposableBean.destroy started");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(BeanA.class.getSimpleName() + ": InitializingBean.afterPropertiesSet started");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
