package com.training.spring.employee.management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.mapper.EmployeeMapper;
import com.training.spring.employee.management.models.Employee;
import com.training.spring.employee.management.rest.models.EmployeeRest;
import com.training.spring.employee.management.services.EmployeeQueryService;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {

    @Autowired
    private EmployeeQueryService eqs;

    @GetMapping("/get/single")
    public EmployeeRest getSingle(@RequestParam("empid") final Long employeeId) {
        Employee employeeLoc = this.eqs.get(employeeId);
        if (employeeLoc != null) {
            return EmployeeMapper.mapper.fromEmployee(employeeLoc);
        }
        return null;
    }

    @GetMapping("/get/all")
    public List<EmployeeRest> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<EmployeeRest> getByName(@RequestParam("name") final String name) {
        List<Employee> employeesLoc = this.eqs.getByName(name);
        if (employeesLoc != null) {
            return EmployeeMapper.mapper.fromEmployees(employeesLoc);
        }
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<EmployeeRest> getBySurname(@RequestParam("surname") final String surname) {
        return null;
    }

}
