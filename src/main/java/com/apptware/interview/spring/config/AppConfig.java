package com.apptware.interview.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String someString() {
        return "someValue"; // or any appropriate value
    }

    // Define other beans if needed
}
