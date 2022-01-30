package com.epam.spring.homework2.beans.validator;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;

public interface Visitor {
    void visitBeanB(BeanB bean);

    void visitBeanC(BeanC bean);

    void visitBeanD(BeanD bean);
}
