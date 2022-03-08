package com.training.spring.employee.management.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "abc")
public class Employee {

    @Id
    @GeneratedValue
    private Long     empId;
    private String   name;
    private String   surname;
    private Integer  height;
    private Integer  weight;
    @Enumerated(EnumType.STRING)
    private EState   state = EState.ACTIVE;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Division division;

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
        return "Employee [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public Long getEmpId() {
        return this.empId;
    }

    public void setEmpId(final Long empIdParam) {
        this.empId = empIdParam;
    }

    public EState getState() {
        return this.state;
    }

    public void setState(final EState stateParam) {
        this.state = stateParam;
    }

    public Division getDivision() {
        return this.division;
    }

    public void setDivision(final Division divisionParam) {
        this.division = divisionParam;
    }
}
