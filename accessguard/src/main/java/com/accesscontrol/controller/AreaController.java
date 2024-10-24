package com.accesscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.AreaDTO;
import com.accesscontrol.services.AreaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaServices areaServices;

    @PostMapping
    public ResponseEntity<AreaDTO> createArea(@Valid @RequestBody AreaDTO areaDTO) {
        AreaDTO createdAreaDTO = areaServices.createArea(areaDTO);
        return new ResponseEntity<>(createdAreaDTO, HttpStatus.CREATED);
    }
}
