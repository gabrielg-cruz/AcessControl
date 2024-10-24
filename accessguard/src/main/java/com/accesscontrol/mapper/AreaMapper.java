package com.accesscontrol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesscontrol.dto.AreaDTO;
import com.accesscontrol.models.Area;

@Mapper
public interface AreaMapper {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    AreaDTO toDTO(Area area);

    @Mapping(target = "id", ignore = true)
    Area toEntity(AreaDTO areaDTO);
}