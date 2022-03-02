package com.training.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr")
public class HelloTr implements IHello {

    @Override
    public String greeting(final String nameParam) {
        return "Selam " + nameParam;
    }


}
