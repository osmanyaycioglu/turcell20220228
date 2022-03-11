package com.training.spring.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(final RequestTemplate templateParam) {
        templateParam.header("X-Origin",
                             "employee-core.employee");
    }

}
