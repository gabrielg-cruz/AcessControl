package com.accesscontrol.interfaces;

import java.util.List;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.AccessLogs;
import com.accesscontrol.models.Area;
import com.accesscontrol.models.Employee;

public interface IAccessLogsServices {
    AccessLogs findAccessLogsEntityById(int id);

    List<AccessLogsDTO> findAll();

    AccessLogsDTO findAccessLogsById(int id);

    AccessLogsDTO createAccessLogs(Employee employee, Area area, AccessLogsDTO accessLogsDTO);

    AccessLogsDTO updateAccessLogs(int id, AccessLogsDTO accessLogsDTO);

    AccessLogsDTO deleteAccessLogs(int id);
}