package com.training.ms.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorClientConfig {

    @Bean
    public GeneralErrorDecoder errorDecoder() {
        return new GeneralErrorDecoder();
    }
}
