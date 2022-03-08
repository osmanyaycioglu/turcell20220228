package com.training.spring.employee.management.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Division {

    @Id
    @GeneratedValue
    private Long   divId;
    private String name;
    private String location;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(final String locationParam) {
        this.location = locationParam;
    }


}
