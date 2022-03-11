package com.training.spring.employee.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.employee.management.data.IEmployeeDataAccessService;
import com.training.spring.employee.management.models.Employee;
import com.training.spring.integration.order.OrderIntService;

@Service
public class EmployeeProvisionService {

    @Autowired
    private IEmployeeDataAccessService dataAccessService;

    @Autowired
    private OrderIntService            orderIntService;

    public String add(final Employee employeeParam) {
        this.dataAccessService.insert(employeeParam);
        String placeOrderLoc = this.orderIntService.placeOrder(employeeParam,
                                                               "defter",
                                                               10);
        return placeOrderLoc;
    }

    public String addx(final Employee employeeParam) {
        String placeOrderLoc = this.orderIntService.placexOrder(employeeParam,
                                                                "defter",
                                                                10);
        return placeOrderLoc;
    }

}

