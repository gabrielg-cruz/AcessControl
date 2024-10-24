package com.accesscontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.dto.AreaDTO;
import com.accesscontrol.interfaces.IAreaServices;
import com.accesscontrol.mapper.AreaMapper;
import com.accesscontrol.models.Area;
import com.accesscontrol.repository.AreaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AreaServices implements IAreaServices {
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public AreaDTO createArea(AreaDTO areaDTO) {
        Area area = AreaMapper.INSTANCE.toEntity(areaDTO);
        Area createdArea = areaRepository.save(area);
        return AreaMapper.INSTANCE.toDTO(createdArea);
    }

    @Override
    public AreaDTO updateArea(int id, AreaDTO updatedArea) {
        Area existingArea = findAreaEntityById(id);
        if (existingArea == null) {
            throw new EntityNotFoundException("Area with the id: " + id + "Was not found");
        }

        existingArea.setName(updatedArea.getName() != null ? updatedArea.getName() : existingArea.getName());

        existingArea.setRoles(updatedArea.getRoles() != null ? updatedArea.getRoles() : existingArea.getRoles());

        return AreaMapper.INSTANCE.toDTO(areaRepository.save(existingArea));
    }

    @Override
    public Area findAreaEntityById(int id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area with the id: " + id + "Was not found"));
    }

    @Override
    public AreaDTO findAreaById(int id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area with the id: " + id + "Was not found"));
        return AreaMapper.INSTANCE.toDTO(area);
    }

    @Override
    public List<AreaDTO> findAll() {
        List<Area> area = areaRepository.findAll();
        return AreaMapper.INSTANCE.toDTOList(area);
    }

    @Override
    public AreaDTO deleteArea(int id) {
        Area area = findAreaEntityById(id);
        areaRepository.delete(area);
        return AreaMapper.INSTANCE.toDTO(area);
    }
}