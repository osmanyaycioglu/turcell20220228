package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsOrderApiApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApiApplication.class,
                              args);
        System.out.println("Running");
    }

}
