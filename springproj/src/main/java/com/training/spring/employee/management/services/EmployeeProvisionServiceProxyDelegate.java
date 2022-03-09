package com.training.spring.employee.management.services;

import com.training.spring.employee.management.models.Employee;

public class EmployeeProvisionServiceProxyDelegate extends EmployeeProvisionService {

    private final EmployeeProvisionService eps;


    public EmployeeProvisionServiceProxyDelegate(final EmployeeProvisionService epsParam) {
        super();
        this.eps = epsParam;
    }


    @Override
    public String add(final Employee employeeParam) {
        String addLoc = null;
        try {
            // Trans
            addLoc = this.eps.add(employeeParam);
            // Commit
        } catch (Exception eLoc) {
            // Rollback
            // TODO: handle exception
        }
        return addLoc;
    }

}
