package com.academy.week3group3final.controller;

import com.academy.week3group3final.exception.RecordNotFoundException;
import com.academy.week3group3final.model.Employee;
import com.academy.week3group3final.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Getting all employees
    @GetMapping()
    public ResponseEntity<Page<Employee>> getEmployees(Pageable pageable) {
        Page<Employee> employee = employeeService.findAllEmployees(pageable);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Getting employee by id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) throws RecordNotFoundException {
        return employeeService.findEmployeeById(id);
    }

    // TODO: Different with sample
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee newEmployee
    ) throws RecordNotFoundException {
        return employeeService.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws RecordNotFoundException {
        employeeService.deleteEmployee(id);
    }

}
