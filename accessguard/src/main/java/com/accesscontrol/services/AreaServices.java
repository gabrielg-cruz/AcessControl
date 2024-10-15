package com.accesscontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.interfaces.IAreaServices;
import com.accesscontrol.models.Area;
import com.accesscontrol.repository.AreaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AreaServices implements IAreaServices {
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area findAreaById(int id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area with the id: " + id + "Was not found"));
    }

    @Override
    public Area deleteArea(int id) {
        Area area = findAreaById(id);
        areaRepository.delete(area);
        return area;
    }

}