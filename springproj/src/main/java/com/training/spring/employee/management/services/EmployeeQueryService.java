package com.training.spring.employee.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.employee.management.data.IEmployeeDataAccessService;
import com.training.spring.employee.management.models.Employee;

@Service
public class EmployeeQueryService {

    @Autowired
    private IEmployeeDataAccessService dataAccessService;

    public Employee get(final Long employeeIdParam) {
        return this.dataAccessService.findById(employeeIdParam);
    }

    public List<Employee> getByName(final String nameParam) {
        return this.dataAccessService.findByName(nameParam);
    }

}
