package com.training.spring.employee.management.services;

import com.training.spring.employee.management.models.Employee;

public class EmployeeProvisionServiceProxy extends EmployeeProvisionService {

    @Override
    public String add(final Employee employeeParam) {
        String addLoc = null;
        try {
            // Trans
            addLoc = super.add(employeeParam);
            // Commit
        } catch (Exception eLoc) {
            // Rollback
            // TODO: handle exception
        }
        return addLoc;
    }

}
