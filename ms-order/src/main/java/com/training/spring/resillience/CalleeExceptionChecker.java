package com.training.spring.resillience;

import java.util.function.Predicate;

public class CalleeExceptionChecker implements Predicate<Exception> {

    @Override
    public boolean test(final Exception tParam) {
        System.out.println("Exception Checker : "
                           + tParam.getClass()
                                   .getName());
        return true;
    }

}
