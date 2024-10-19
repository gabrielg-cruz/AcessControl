package com.accesscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.EmployeeDTO;

import com.accesscontrol.services.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO createdEmployeeDTO = employeeServices.createEmployee(employeeDTO);

        return new ResponseEntity<>(createdEmployeeDTO, HttpStatus.CREATED);
    }
}