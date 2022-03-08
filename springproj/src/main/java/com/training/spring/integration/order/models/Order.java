package com.training.spring.integration.order.models;


public class Order {

    private Long    employeeId;
    private Integer amount;
    private String  type;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String typeParam) {
        this.type = typeParam;
    }


}
