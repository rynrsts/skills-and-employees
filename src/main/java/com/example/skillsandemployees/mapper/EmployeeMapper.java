package com.example.skillsandemployees.mapper;

import com.example.skillsandemployees.dto.EmployeeDTO;
import com.example.skillsandemployees.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee dtoToModel(EmployeeDTO employeeDTO);

    EmployeeDTO modelToDto(Employee employee);

}
