package com.training.spring.employee.management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.spring.employee.management.models.Employee;
import com.training.spring.employee.management.rest.models.EmployeeRest;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeRest employeeRestParam);

    EmployeeRest fromEmployee(Employee employeeRestParam);

    List<Employee> toEmployees(List<EmployeeRest> employeeRests);

    List<EmployeeRest> fromEmployees(List<Employee> employes);


}
