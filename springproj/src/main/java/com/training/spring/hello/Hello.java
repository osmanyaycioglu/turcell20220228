package com.training.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("eng")
public class Hello implements IHello {

    @Override
    public String greeting(final String nameParam) {
        return "Hello " + nameParam;
    }


}
