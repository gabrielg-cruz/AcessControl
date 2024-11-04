package com.accesscontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesscontrol.models.AccessLogs;

@Repository
public interface AccessLogsRepository extends JpaRepository<AccessLogs, Integer> {
    List<AccessLogs> findByEmployeeId(int employeeId);

    List<AccessLogs> findByAreaId(int areaId);
}