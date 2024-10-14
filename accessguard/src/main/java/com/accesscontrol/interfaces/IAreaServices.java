package com.accesscontrol.interfaces;

import com.accesscontrol.models.Area;

public interface IAreaServices {
    Area createArea(Area area);

    Area updateArea(Area area);

    Area findAreaById(int id);

    Area deleteArea(int id);
}