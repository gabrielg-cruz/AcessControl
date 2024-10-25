package com.accesscontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accesscontrol.models.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    Optional<Area> findByName(String name);

    @Query("SELECT a FROM Area a LEFT JOIN FETCH a.roles WHERE a.id = :id")
    Optional<Area> findByIdWithRoles(@Param("id") int id);
}