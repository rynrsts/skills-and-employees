package com.academy.week3group3final.service;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Employee;
import com.academy.week3group3final.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Page<Employee> findAllEmployees(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee findEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Employee updateEmployee(Employee newEmployee, Long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            return employeeRepo.save(employee);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteEmployee(Long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            employeeRepo.delete(employeeOptional.get());
        } else {
            throw new RecordNotFoundException();
        }
    }

}
