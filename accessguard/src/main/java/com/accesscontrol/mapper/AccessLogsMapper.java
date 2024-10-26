package com.accesscontrol.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesscontrol.dto.AccessLogsDTO;
import com.accesscontrol.models.AccessLogs;

public interface AccessLogsMapper {
    AccessLogsMapper INSTANCE = Mappers.getMapper(AccessLogsMapper.class);

    AccessLogsDTO toDTO(AccessLogs accessLogs);

    @Mapping(target = "id", ignore = true)
    AccessLogs toEntity(AccessLogsDTO accessLogsDTO);
}