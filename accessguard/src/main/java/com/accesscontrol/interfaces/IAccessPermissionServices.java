package com.accesscontrol.interfaces;

import com.accesscontrol.models.Area;
import com.accesscontrol.models.Employee;

public interface IAccessPemissionServices {
    public boolean isMaintenance(Employee employee);

    public boolean isAllowed(Employee employee, Area area);
}
