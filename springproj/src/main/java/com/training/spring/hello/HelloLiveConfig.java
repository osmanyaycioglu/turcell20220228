package com.training.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("live")
public class HelloLiveConfig {

    @Autowired
    private Environment        env;

    @Autowired
    private ApplicationContext ac;

    @Bean
    public IHello helloBean() {
        return new Hello();
    }

    @Bean
    public IHello helloDynBean(@Value("${app.hello.greeting.str}") final String dynString) {
        return new HelloDyn(dynString);
    }

    @Bean
    public String dynText() {
        return this.env.getProperty("app.hello.greeting.str");
    }


}
