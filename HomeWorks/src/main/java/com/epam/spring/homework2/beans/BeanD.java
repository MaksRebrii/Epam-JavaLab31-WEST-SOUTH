package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.validator.FieldsValidator;
import com.epam.spring.homework2.beans.validator.MyValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements MyValidator {

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
    public void validate() {
        System.out.println(this.getClass().getSimpleName() + ". validate method started");
        FieldsValidator.validate(this.getClass().getSimpleName(), this.name, this.value);
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
