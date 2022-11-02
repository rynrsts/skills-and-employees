package com.academy.week3group3final.service;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Page<Employee> findAllEmployees(Pageable pageable);

    Employee findEmployeeById(Long id) throws RecordNotFoundException;

    Employee updateEmployee(Employee newEmployee, Long id) throws RecordNotFoundException;

    void deleteEmployee(Long id) throws RecordNotFoundException;

}
