package com.accesscontrol.interfaces;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.AccessLogs;
import com.accesscontrol.models.Employee;

public interface IAccessLogsServices {
    AccessLogs findAccessLogsEntityById(int id);

    AccessLogsDTO findAccessLogsById(int id);

    AccessLogsDTO createAccessLogs(Employee employee, AccessLogsDTO accessLogsDTO);

    AccessLogsDTO updateAccessLogs(int id, AccessLogsDTO accessLogsDTO);

    AccessLogsDTO deleteAccessLogs(int id);
}