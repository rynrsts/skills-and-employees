package com.example.skillsandemployees.service;

import com.example.skillsandemployees.dto.EmployeeDTO;
import com.example.skillsandemployees.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    Page<EmployeeDTO> findAllEmployees(Pageable pageable);

    EmployeeDTO findEmployeeById(Long id) throws RecordNotFoundException;

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws RecordNotFoundException;

    String deleteEmployee(Long id) throws RecordNotFoundException;

}
