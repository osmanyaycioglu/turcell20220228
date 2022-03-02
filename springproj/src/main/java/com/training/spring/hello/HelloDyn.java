package com.training.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloDyn implements IHello {

    private final String prefix;

    public HelloDyn(@Qualifier("dynText") final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }


    @Override
    public String greeting(final String nameParam) {
        return this.prefix + " " + nameParam;
    }


}
