package com.accesscontrol.interfaces;

import java.util.List;

import com.accesscontrol.dto.EmployeeDTO;
import com.accesscontrol.models.Employee;

public interface IEmployeeServices {
    EmployeeDTO createEmployee(EmployeeDTO updatedEmployeeDTO);

    EmployeeDTO updateEmployee(int id, EmployeeDTO updateEmployeeDTO);

    List<EmployeeDTO> findAll();

    Employee findEmployeeEntityById(int id);

    EmployeeDTO findEmployeeById(int id);

    EmployeeDTO findEmployeeByEmail(String email);

    EmployeeDTO findEmployeeByName(String name);

    EmployeeDTO deleteEmployee(int id);
}