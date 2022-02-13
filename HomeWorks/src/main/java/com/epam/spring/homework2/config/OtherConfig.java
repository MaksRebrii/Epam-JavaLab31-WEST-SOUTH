package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("com.epam.spring.homework2.beans")
public class OtherConfig {

    @Bean
    @Lazy
    BeanF beanF() {
        return new BeanF();
    }
}
