package com.training.spring.employee.management.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeProvisionControllerDont {

    @PostMapping("/provision/{op}")
    public ResponseEntity<?> doAll(@PathVariable("op") final String op,
                                   final HttpServletRequest requestParam) throws IOException {
        switch (op) {
            case "add":
                requestParam.getParameter("xyz");
                requestParam.getReader();
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                                     .header("xyz",
                                             "deneme")
                                     .body("OK");
            case "deactivate":
                requestParam.getParameter("xyz");
                requestParam.getReader();
                break;

            default:
                break;
        }
        return null;
    }

}
