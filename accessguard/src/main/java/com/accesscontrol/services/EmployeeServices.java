package com.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.dto.EmployeeDTO;
import com.accesscontrol.interfaces.IEmployeeServices;
import com.accesscontrol.mapper.EmployeeMapper;
import com.accesscontrol.models.Employee;
import com.accesscontrol.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.toDTO(createdEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO updatedEmployeeDTO) {
        Employee existingEmployee = findEmployeeEntityById(id);
        if (existingEmployee == null) {
            throw new EntityNotFoundException("Employee with the id: " + id + "Was not found");
        }

        existingEmployee
                .setName(updatedEmployeeDTO.getName() != null ? updatedEmployeeDTO.getName()
                        : existingEmployee.getName());

        existingEmployee
                .setEmail(
                        updatedEmployeeDTO.getEmail() != null ? updatedEmployeeDTO.getEmail()
                                : existingEmployee.getEmail());

        existingEmployee
                .setRole(updatedEmployeeDTO.getRole() != null ? updatedEmployeeDTO.getRole()
                        : existingEmployee.getRole());

        return EmployeeMapper.INSTANCE.toDTO(employeeRepository.save(existingEmployee));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO findEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the id: " + id + "Was not found"));
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }

    @Override
    public Employee findEmployeeEntityById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the id: " + id + "Was not found"));
    }

    @Override
    public EmployeeDTO findEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the email: " + email + "Was not found"));
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }

    @Override
    public EmployeeDTO findEmployeeByName(String name) {
        Employee employee = employeeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Employee with the name: " + name + "Was not found"));
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }

    @Override
    public EmployeeDTO deleteEmployee(int id) {
        Employee employee = findEmployeeEntityById(id);
        employeeRepository.delete(employee);
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }
}