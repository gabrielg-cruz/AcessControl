package com.accesscontrol.mapper;

import java.util.List;

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

    List<EmployeeDTO> toDTOList(List<Employee> employee);

    List<Employee> toEntityList(List<EmployeeDTO> employeeDTO);
}