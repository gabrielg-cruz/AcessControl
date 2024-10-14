package com.accesscontrol.interfaces;

import com.accesscontrol.models.Employee;

public interface IEmployeeServices {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    Employee findEmployeeById(int id);

    Employee findEmployeeByEmail(String email);

    Employee findEmployeeByName(String name);

    Employee deleteEmployee(int id);
}