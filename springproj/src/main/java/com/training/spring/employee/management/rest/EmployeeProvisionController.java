package com.training.spring.employee.management.rest;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.models.EmployeeRest;

@RestController
@RequestMapping("/api/v1/employee/provision")
@Validated
public class EmployeeProvisionController {

    @PostMapping("/add")
    public String add(@Validated @RequestBody final EmployeeRest employeeRestParam) {
        if (employeeRestParam.getHeight() > 230) {
            throw new IllegalArgumentException("xyz");
        }
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@NotNull @RequestParam("empid") final Long employeeId) {
        if (employeeId == null) {
            throw new IllegalArgumentException();
        }
        return "OK";
    }


}
