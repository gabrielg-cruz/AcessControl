package com.accesscontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesscontrol.models.AccessLogs;

@Repository
public interface AccessLogsRepository extends JpaRepository<AccessLogs, Integer> {

}