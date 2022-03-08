package com.training.spring.employee.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.spring.employee.management.models.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameIn(List<String> name);

    List<Employee> findByNameLike(String name);

    List<Employee> findByNameAndSurname(String name,
                                        String surname);

    List<Employee> findByNameAndSurnameOrderByName(String name,
                                                   String surname);

    @Query("select e from Employee e where e.name=?1")
    List<Employee> searchName(String name);

    @Query("select e from Employee e where e.division.name =?1")
    List<Employee> searchDivision(String divName);

    @Query(value = "select * from employee e where e.name=?1", nativeQuery = true)
    List<Employee> searchNameNative(String name);

    @Query(value = "select * from employee e where e.name=?1", nativeQuery = true)
    List<Object[]> searchNameDynamicNative(String name);


}
