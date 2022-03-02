package com.training.spring.employee.management.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.models.EmployeeRest;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionControllerDesign2 {

    @PutMapping
    public String add(@RequestBody final EmployeeRest employeeRestParam) {
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@RequestParam("empid") final Long employeeId) {
        return "OK";
    }


}
