package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import(OtherConfig.class)
@PropertySource("classpath:application.properties")
public class BeanConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn(value = "beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn({"beanD", "beanB"})
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }
}
