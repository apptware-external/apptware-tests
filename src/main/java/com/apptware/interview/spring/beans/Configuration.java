package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public String someString() {
        return "Dummy Values";
    }


    @Bean
    @Qualifier("onDemandA")
    public OnDemandA onDemandA() {
        return new OnDemandA("Hello World!!!");
    }

    @Bean
    @Qualifier("onDemandB")
    public OnDemandB onDemandB() {
        return new OnDemandB("Hello Other World!!!");
    }
}
