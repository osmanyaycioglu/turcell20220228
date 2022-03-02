package com.training.spring.employee.management.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.employee.management.models.EmployeeRest;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {

    @GetMapping("/get/single")
    public EmployeeRest getSingle(@RequestParam("empid") final Long employeeId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<EmployeeRest> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<EmployeeRest> getByName(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<EmployeeRest> getBySurname(@RequestParam("surname") final String surname) {
        return null;
    }

}
