package com.training.ms.error;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "microservice.info")
public class MicroserviceInfo {

    private String boundedContext;
    private String name;

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }


}
