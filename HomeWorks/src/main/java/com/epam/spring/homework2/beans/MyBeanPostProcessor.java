package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.SelfValidatingBean;
import com.epam.spring.homework2.beans.validator.BeanValueValidator;
import com.epam.spring.homework2.beans.validator.BeanValidatingVisitor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private final BeanValidatingVisitor beanVisitor;

    public MyBeanPostProcessor(BeanValueValidator visitor) {
        this.beanVisitor = visitor;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SelfValidatingBean) {
            ((SelfValidatingBean) bean).accept(beanVisitor);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
