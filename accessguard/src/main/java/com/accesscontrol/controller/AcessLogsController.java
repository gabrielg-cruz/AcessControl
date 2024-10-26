package com.accesscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.Employee;
import com.accesscontrol.services.AccessLogsServices;
import com.accesscontrol.services.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accesslogs")
public class AcessLogsController {
    @Autowired
    private AccessLogsServices accessLogsServices;
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<AccessLogsDTO> createAccessLog(@Valid @RequestBody AccessLogsDTO accessLogsDTO) {
        int employeeId = accessLogsDTO.getEmployeeId();
        Employee employee = employeeServices.findEmployeeEntityById(employeeId);
        AccessLogsDTO createdAccessLogsDTO = accessLogsServices.createAccessLogs(employee, accessLogsDTO);

        return new ResponseEntity<>(createdAccessLogsDTO, HttpStatus.CREATED);
    }
}