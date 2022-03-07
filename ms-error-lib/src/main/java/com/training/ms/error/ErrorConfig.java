package com.training.ms.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {

    @Bean
    public RestErrorAdvice restErrorAdvice() {
        return new RestErrorAdvice();
    }

    @Bean
    public MicroserviceInfo microserviceInfo() {
        return new MicroserviceInfo();
    }

}
