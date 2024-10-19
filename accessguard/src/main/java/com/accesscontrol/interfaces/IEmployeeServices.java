package com.accesscontrol.interfaces;

import com.accesscontrol.dto.EmployeeDTO;
import com.accesscontrol.models.Employee;

public interface IEmployeeServices {
    EmployeeDTO createEmployee(EmployeeDTO updatedEmployeeDTO);

    EmployeeDTO updateEmployee(int id, EmployeeDTO updateEmployeeDTO);

    Employee findEmployeeById(int id);

    EmployeeDTO findEmployeeByEmail(String email);

    EmployeeDTO findEmployeeByName(String name);

    EmployeeDTO deleteEmployee(int id);
}