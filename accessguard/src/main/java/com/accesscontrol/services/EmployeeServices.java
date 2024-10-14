package com.accesscontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.interfaces.IEmployeeServices;
import com.accesscontrol.models.Employee;
import com.accesscontrol.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existingEmployee = findEmployeeById(id);
        if (existingEmployee == null) {
            throw new EntityNotFoundException("Employee with the id: " + id + "Was not found");
        }

        existingEmployee
                .setName(updatedEmployee.getName() != null ? updatedEmployee.getName() : existingEmployee.getName());

        existingEmployee
                .setEmail(
                        updatedEmployee.getEmail() != null ? updatedEmployee.getEmail() : existingEmployee.getEmail());

        existingEmployee
                .setRole(updatedEmployee.getRole() != null ? updatedEmployee.getRole() : existingEmployee.getRole());

        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the id: " + id + "Was not found"));
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the email: " + email + "Was not found"));
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the name: " + name + "Was not found"));
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}