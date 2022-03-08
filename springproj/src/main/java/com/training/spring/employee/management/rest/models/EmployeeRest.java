package com.training.spring.employee.management.rest.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EmployeeRest {

    @NotEmpty
    @Size(max = 25, min = 2, message = "Name 2 ile 25 arasında olmalı")
    // @StartWith("n:")
    private String  name;
    @NotEmpty
    @Size(max = 25, min = 2, message = "Name 2 ile 25 arasında olmalı")
    // @StartWith("s:")
    private String  surname;
    @Max(300)
    @Min(50)
    @Positive
    private Integer height;
    @Max(300)
    @Min(30)
    @Positive
    private Integer weight;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }
}
