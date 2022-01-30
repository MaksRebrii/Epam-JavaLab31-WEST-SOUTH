package com.epam.spring.homework2.beans.validator;

import com.epam.spring.homework2.beans.BaseBean;

import java.util.function.Consumer;

public interface BeanValidatingVisitor extends Consumer<BaseBean> {

}
