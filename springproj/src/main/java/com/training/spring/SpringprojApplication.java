package com.training.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.ms.error.ErrorClientConfig;
import com.training.ms.error.ErrorConfig;
import com.training.spring.hello.Hello;

import a.b.c.AbcFeatureConfig;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring",
//                                            "a.b.c"
//})
@SpringBootApplication
@Import({
          AbcFeatureConfig.class,
          ErrorConfig.class,
          ErrorClientConfig.class
})
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients
public class SpringprojApplication {

    // Field Injection
    @Autowired
    private Hello       hello;

    private final Hello hello2;

    private Hello       hello3;

    // Constructor Injection
    public SpringprojApplication(final Hello helloParam) {
        this.hello2 = helloParam;
    }

    // Method Injection
    @Autowired
    public void injectMe(final Hello helloParam) {
        this.hello3 = helloParam;
    }

    @PostConstruct
    public void initMe() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    public void sayHello(final String name) {
        System.out.println(this.hello.greeting(name));
    }

    public static void main(final String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringprojApplication.class,
                                                                          args);

        SpringprojApplication beanLoc = contextLoc.getBean(SpringprojApplication.class);
        beanLoc.sayHello("osman");
    }

}
