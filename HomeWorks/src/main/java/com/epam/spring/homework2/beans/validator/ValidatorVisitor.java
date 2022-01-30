package com.epam.spring.homework2.beans.validator;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.stereotype.Component;

@Component
public class ValidatorVisitor implements Visitor {

    public static final String VALIDATE_METHOD_STARTED = ". validate method started";

    @Override
    public void visitBeanB(BeanB bean) {
        System.out.println(bean.getClass().getSimpleName() + VALIDATE_METHOD_STARTED);
        FieldsValidator.validate(bean.getClass().getSimpleName(), bean.getName(), bean.getValue());
    }

    @Override
    public void visitBeanC(BeanC bean) {
        System.out.println(bean.getClass().getSimpleName() + VALIDATE_METHOD_STARTED);
        FieldsValidator.validate(bean.getClass().getSimpleName(), bean.getName(), bean.getValue());
    }

    @Override
    public void visitBeanD(BeanD bean) {
        System.out.println(bean.getClass().getSimpleName() + VALIDATE_METHOD_STARTED);
        FieldsValidator.validate(bean.getClass().getSimpleName(), bean.getName(), bean.getValue());
    }
}
