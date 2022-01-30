package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.MyValidator;
import com.epam.spring.homework2.beans.validator.ValidatorVisitor;
import com.epam.spring.homework2.beans.validator.Visitor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private final Visitor visitor;

    public MyBeanPostProcessor(ValidatorVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyValidator) {
            ((MyValidator) bean).validate(visitor);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
