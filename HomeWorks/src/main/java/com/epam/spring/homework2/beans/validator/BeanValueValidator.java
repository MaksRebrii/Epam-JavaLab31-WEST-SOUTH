package com.epam.spring.homework2.beans.validator;

import com.epam.spring.homework2.beans.BaseBean;
import org.springframework.stereotype.Component;

@Component
public class BeanValueValidator implements BeanValidatingVisitor {

    public static final String VALIDATE_METHOD_STARTED = ". validate method started";

    @Override
    public void accept(final BaseBean bean) {
        System.out.println(bean.getClass().getSimpleName() + VALIDATE_METHOD_STARTED);
        FieldsValidator.validate(bean.getClass().getSimpleName(), bean.getName(), bean.getValue());
    }
}
