package com.training.spring.employee.management.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.mapper.EmployeeMapper;
import com.training.spring.employee.management.models.Employee;
import com.training.spring.employee.management.rest.models.EmployeeRest;
import com.training.spring.employee.management.services.EmployeeProvisionService;

@RestController
@RequestMapping("/api/v1/employee/provision")
@Validated
public class EmployeeProvisionController {

    @Autowired
    private EmployeeProvisionService eps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final EmployeeRest employeeRestParam) {
        Employee employeeLoc = EmployeeMapper.mapper.toEmployee(employeeRestParam);
        return this.eps.add(employeeLoc);
    }

    @GetMapping("/deactivate")
    public String deactivate(@NotNull @RequestParam("empid") final Long employeeId) {
        if (employeeId == null) {
            throw new IllegalArgumentException();
        }
        return "OK";
    }


}
