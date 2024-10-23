package com.accesscontrol.dto;

import java.util.Set;

import com.accesscontrol.enums.Role;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;

public class AreaDTO {
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ElementCollection(targetClass = Role.class)
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

}