package com.accesscontrol.models;

import java.util.Set;

import com.accesscontrol.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ElementCollection(targetClass = Role.class)
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}