package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.training.spring.hello.IHello;

import a.b.c.Greet;

@Component
//@Controller
//@Service
//@Repository
//@Configuration
public class MyApplicationRunner implements ApplicationRunner {


    @Autowired
    private Greet  gr;

    @Autowired
    @Qualifier("helloBean")
    private IHello hel;

    @Autowired
    @Qualifier("helloDynBean")
    private IHello hel2;

    @Autowired
    @Qualifier("helloDyn")
    private IHello hel3;


    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println("--------------Static--------------------");
        System.out.println(this.hel.greeting("mehmet"));
        System.out.println("--------------Dyn--------------------");
        System.out.println(this.hel2.greeting("ali"));
        System.out.println("--------------Dyn class--------------------");
        System.out.println(this.hel3.greeting("ayşe"));
        System.out.println("--------------Greet--------------------");
        this.gr.greet();
    }

}
