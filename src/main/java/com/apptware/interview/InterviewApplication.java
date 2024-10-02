package com.apptware.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
class InterviewApplication {
  public static void main(String[] args) {
    SpringApplication.run(InterviewApplication.class, args);
  }
}
