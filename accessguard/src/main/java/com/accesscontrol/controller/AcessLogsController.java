package com.accesscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.services.AccessLogsServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accesslogs")
public class AcessLogsController {
    @Autowired
    private AccessLogsServices accessLogsServices;

    @PostMapping
    public ResponseEntity<AccessLogsDTO> createdEmployee(@Valid @RequestBody AccessLogsDTO accessLogsDTO) {

        AccessLogsDTO createdAccessLogsDTO = accessLogsServices.createAccessLogs(accessLogsDTO);

        return new ResponseEntity<>(createdAccessLogsDTO, HttpStatus.CREATED);
    }

}
