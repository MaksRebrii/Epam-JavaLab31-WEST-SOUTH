package com.epam.spring.homework2.beans.validator;

import java.util.function.Consumer;

public interface SelfValidatingBean extends Consumer<BeanValidatingVisitor> {

}
