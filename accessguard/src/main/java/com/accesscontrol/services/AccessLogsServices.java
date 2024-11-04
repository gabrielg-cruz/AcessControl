package com.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.interfaces.IAccessLogsServices;
import com.accesscontrol.mapper.AccessLogsMapper;
import com.accesscontrol.models.AccessLogs;
import com.accesscontrol.models.Area;
import com.accesscontrol.models.Employee;
import com.accesscontrol.repository.AccessLogsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccessLogsServices implements IAccessLogsServices {
    @Autowired
    private AccessLogsRepository accessLogsRepository;

    @Autowired
    private AccessPermissionServices accessPermissionServices;

    @Override
    public List<AccessLogsDTO> findAll() {
        List<AccessLogs> accessLogs = accessLogsRepository.findAll();
        return AccessLogsMapper.INSTANCE.toDTOList(accessLogs);
    }

    @Override
    public AccessLogs findAccessLogsEntityById(int id) {
        return accessLogsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AccessLogs with the id: " + id + "Was not found"));
    }

    @Override
    public AccessLogsDTO findAccessLogsById(int id) {
        AccessLogs accesslogs = findAccessLogsEntityById(id);
        return AccessLogsMapper.INSTANCE.toDTO(accesslogs);
    }

    @Override
    public AccessLogsDTO createAccessLogs(Employee employee, Area area, AccessLogsDTO accessLogsDTO) {
        if (!accessPermissionServices.isMaintenance(employee) && !accessPermissionServices.isAllowed(employee, area))
            throw new IllegalArgumentException("Employee is not allowed to access this area");

        AccessLogs accessLogs = AccessLogsMapper.INSTANCE.toEntity(accessLogsDTO);
        AccessLogs createdAccessLogs = accessLogsRepository.save(accessLogs);
        return AccessLogsMapper.INSTANCE.toDTO(createdAccessLogs);
    }

    @Override
    public List<AccessLogsDTO> findAccessLogsByEmployeeId(int employeeId) {
        List<AccessLogs> accessLogs = accessLogsRepository.findByEmployeeId(employeeId);
        return AccessLogsMapper.INSTANCE.toDTOList(accessLogs);
    }

    @Override
    public List<AccessLogsDTO> findAccessLogsByAreaId(int areaId) {
        List<AccessLogs> accessLogs = accessLogsRepository.findByAreaId(areaId);
        return AccessLogsMapper.INSTANCE.toDTOList(accessLogs);
    }

    @Override
    public AccessLogsDTO updateAccessLogs(int id, AccessLogsDTO accessLogsDTO) {
        AccessLogs accesslogs = findAccessLogsEntityById(id);
        if (accesslogs == null) {
            throw new EntityNotFoundException("AccessLogs with the id: " + id + "Was not found");
        }

        return AccessLogsMapper.INSTANCE.toDTO(accessLogsRepository.save(accesslogs));
    }

    @Override
    public AccessLogsDTO deleteAccessLogs(int id) {
        AccessLogs accessLogs = findAccessLogsEntityById(id);
        accessLogsRepository.delete(accessLogs);
        return AccessLogsMapper.INSTANCE.toDTO(accessLogs);
    }
}