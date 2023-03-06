package com.example.skillsandemployees.service;

import com.example.skillsandemployees.dto.EmployeeDTO;
import com.example.skillsandemployees.exception.RecordNotFoundException;
import com.example.skillsandemployees.mapper.EmployeeMapper;
import com.example.skillsandemployees.model.Employee;
import com.example.skillsandemployees.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.save(employeeMapper.dtoToModel(employeeDTO));
        return employeeMapper.modelToDto(employee);
    }

    @Override
    public Page<EmployeeDTO> findAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(employeeMapper::modelToDto);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        return employeeMapper.modelToDto(employeeOptional.get());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        Employee employee = employeeOptional.get();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(employeeDTO, employee);
        employeeRepository.save(employee);
        return employeeMapper.modelToDto(employee);
    }

    @Override
    public String deleteEmployee(Long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RecordNotFoundException("Record not found");
        }
        employeeRepository.delete(employeeOptional.get());
        return "Employee with id " + id + " has been deleted";
    }

}
