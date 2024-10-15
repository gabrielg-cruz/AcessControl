package com.accesscontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesscontrol.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByName(String name);
}