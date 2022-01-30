package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Import(OtherConfig.class)
@PropertySource("classpath:application.properties")
public class BeanConfig {

    @Value("${beanB.name}")
    private String beanBName;

    @Value("${beanB.value}")
    private int beanBValue;

    @Value("${beanC.name}")
    private String beanCName;

    @Value("${beanC.value}")
    private int beanCValue;

    @Value("${beanD.name}")
    private String beanDName;

    @Value("${beanD.value}")
    private int beanDValue;

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn(value = "beanD")
    public BeanB beanB() {
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn({"beanD", "beanB"})
    public BeanC beanC() {
        return new BeanC(beanCName, beanCValue);
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanD beanD() {
        return new BeanD(beanDName, beanDValue);
    }
}
