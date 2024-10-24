package com.accesscontrol.interfaces;

import java.util.List;

import com.accesscontrol.dto.AreaDTO;
import com.accesscontrol.models.Area;

public interface IAreaServices {
    Area findAreaEntityById(int id);

    List<Area> findAll();

    AreaDTO createArea(AreaDTO area);

    AreaDTO updateArea(int id, AreaDTO area);

    AreaDTO findAreaById(int id);

    AreaDTO deleteArea(int id);
}