package com.training.spring.resillience;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class Callee {

    private int counter = 0;

    // @Retry(name = "xyzretry", fallbackMethod = "trymeFallback")
    @CircuitBreaker(name = "mycb")
    public String tryme(final String str) {
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalStateException("problem");
        }
        return "test -> " + str;
    }

    public String trymeFallback(final String str,
                                final Exception exp) {
        System.out.println("Fallback : " + this.counter);
        return "test fallback : " + str;
    }

}
