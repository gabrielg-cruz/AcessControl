package com.accesscontrol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesscontrol.dto.EmployeeDTO;
import com.accesscontrol.models.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);
}