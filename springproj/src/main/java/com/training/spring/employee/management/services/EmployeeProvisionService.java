package com.training.spring.employee.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.employee.management.data.IEmployeeDataAccessService;
import com.training.spring.employee.management.models.Employee;

@Service
public class EmployeeProvisionService {

    @Autowired
    private IEmployeeDataAccessService dataAccessService;


    public String add(final Employee employeeParam) {
        this.dataAccessService.insert(employeeParam);
        return "OK";
    }

}
