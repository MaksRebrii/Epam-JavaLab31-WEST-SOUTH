package com.epam.spring.homework2;

import com.epam.spring.homework2.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println(System.lineSeparator() + "Beans in container:");
        for (String beanName :
                context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        context.close();
    }


}
