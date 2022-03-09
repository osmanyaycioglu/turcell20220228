package com.training.spring.employee.management.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.employee.management.models.Employee;
import com.training.spring.employee.management.repository.IEmployeeDao;

@Service
public class EmployeeDataAccessService implements IEmployeeDataAccessService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public void insert(final Employee employeeParam) {
        this.employeeDao.save(employeeParam);
    }

    @Override
    public Employee findById(final Long employeeIdParam) {
        return this.employeeDao.findById(employeeIdParam)
                               .orElse(null);
    }

    @Override
    public List<Employee> findByName(final String nameParam) {
        return this.employeeDao.findByName(nameParam);
    }

}
