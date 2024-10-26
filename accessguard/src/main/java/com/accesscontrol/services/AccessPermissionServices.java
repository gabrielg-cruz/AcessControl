package com.accesscontrol.services;

import org.springframework.stereotype.Service;

import com.accesscontrol.enums.Role;
import com.accesscontrol.interfaces.IAccessPemissionServices;
import com.accesscontrol.models.Area;
import com.accesscontrol.models.Employee;

@Service
public class AccessPermissionServices implements IAccessPemissionServices {
    @Override
    public boolean isMaintenance(Employee employee) {
        System.out.printf("Employee role: %s\n", employee.getRole());
        return employee.getRole() == Role.Maintenance;
    }

    @Override
    public boolean isAllowed(Employee employee, Area area) {
        for (Role role : area.getRoles()) {
            if (employee.getRole() == role) {
                return true;
            }
        }
        return false;
    }
}