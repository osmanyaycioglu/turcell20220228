package com.training.spring.resillience;

import java.util.function.Predicate;

public class CalleeResultChecker implements Predicate<String> {

    @Override
    public boolean test(final String tParam) {
        return tParam.contains("7");
    }

}
