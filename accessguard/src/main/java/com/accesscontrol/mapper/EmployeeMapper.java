package com.accesscontrol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.accesscontrol.dto.EmployeeDTO;
import com.accesscontrol.models.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);
}

// public class EmployeeMapper {
// public static EmployeeDTO toDTO(Employee employee) {
// if (employee == null)
// return null;

// return new EmployeeDTO(employee.getId(), employee.getName(),
// employee.getEmail(), employee.getRole());
// }

// public static Employee toEntity(EmployeeDTO employeeDTO) {
// if (employeeDTO == null)
// return null;

// Employee employee = new Employee();
// employee.setId(employeeDTO.getId());
// employee.setName(employeeDTO.getName());
// employee.setEmail(employeeDTO.getEmail());
// employee.setRole(employeeDTO.getRole());

// return employee;
// }
// }