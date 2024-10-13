package com.accesscontrol.interfaces;

import com.accesscontrol.models.Employee;

public interface IEmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee findEmployeeById(int id);

    Employee findEmployeeByEmail(String email);
    
}