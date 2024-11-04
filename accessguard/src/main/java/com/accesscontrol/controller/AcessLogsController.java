package com.accesscontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.Area;
import com.accesscontrol.models.Employee;
import com.accesscontrol.services.AccessLogsServices;
import com.accesscontrol.services.AreaServices;
import com.accesscontrol.services.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accesslogs")
public class AcessLogsController {
    @Autowired
    private AccessLogsServices accessLogsServices;
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private AreaServices areaServices;

    @PostMapping
    public ResponseEntity<AccessLogsDTO> createAccessLog(@Valid @RequestBody AccessLogsDTO accessLogsDTO) {
        int employeeId = accessLogsDTO.getEmployeeId();
        int areaId = accessLogsDTO.getAreaId();

        Employee employee = employeeServices.findEmployeeEntityById(employeeId);
        Area area = areaServices.findAreaEntityById(areaId);

        AccessLogsDTO createdAccessLogsDTO = accessLogsServices.createAccessLogs(employee, area, accessLogsDTO);

        return new ResponseEntity<>(createdAccessLogsDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccessLogsDTO>> getAllAccessLogs() {
        List<AccessLogsDTO> accessLogs = accessLogsServices.findAll();
        return ResponseEntity.ok(accessLogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessLogsDTO> getAccessLog(@PathVariable int id) {
        AccessLogsDTO accessLogs = accessLogsServices.findAccessLogsById(id);
        return new ResponseEntity<>(accessLogs, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAccessLog(@PathVariable int id) {
        accessLogsServices.deleteAccessLogs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}