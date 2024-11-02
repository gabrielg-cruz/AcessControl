package com.accesscontrol.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.AccessLogs;

@Mapper
public interface AccessLogsMapper {
    AccessLogsMapper INSTANCE = Mappers.getMapper(AccessLogsMapper.class);

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "areaId", source = "area.id")
    AccessLogsDTO toDTO(AccessLogs accessLogs);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee.id", source = "employeeId")
    @Mapping(target = "area.id", source = "areaId")
    AccessLogs toEntity(AccessLogsDTO accessLogsDTO);

    List<AccessLogsDTO> toDTOList(List<AccessLogs> accessLogs);

    List<AccessLogs> toEntityList(List<AccessLogsDTO> areaDTO);
}