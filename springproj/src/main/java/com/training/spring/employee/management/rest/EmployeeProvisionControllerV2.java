package com.training.spring.employee.management.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.rest.models.EmployeeRest;

@RestController
@RequestMapping("/api/v2/employee/provision")
public class EmployeeProvisionControllerV2 {

    @PostMapping("/add")
    public String add(@RequestBody final EmployeeRest employeeRestParam) {
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("empid") final Long employeeId) {
        return "OK";
    }

}
