package com.training.spring.employee.management.data;

import java.util.List;

import com.training.spring.employee.management.models.Employee;

public interface IEmployeeDataAccessService {

    public void insert(final Employee employeeParam);

    public Employee findById(Long employeeIdParam);

    public List<Employee> findByName(String nameParam);
}
