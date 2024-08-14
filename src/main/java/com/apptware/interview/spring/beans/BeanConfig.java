package com.apptware.interview.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("someStringA")
    public String getSomeStringA() {
        return "Hello World!!!";
    }

    @Bean("someStringB")
    public String getSomeStringB() {
        return "Hello Other World!!!";
    }
}
