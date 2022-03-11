package com.training.spring.resillience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {

    @Autowired
    private Callee callee;

    public String startTest(final String testStr) {
        return this.callee.tryme(testStr);
    }

}
