package com.accesscontrol.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class AccessLogsDTO {
    private int id;

    @NotBlank(message = "Employee id is mandatory")
    private int employeeId;

    @NotBlank(message = "Access time is mandatory")
    private LocalDateTime accessTime;

    @NotBlank(message = "Exit time is mandatory")
    private LocalDateTime exitTime;

    public AccessLogsDTO(int id, int employeeId, LocalDateTime accessTime, LocalDateTime exitTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.accessTime = accessTime;
        this.exitTime = exitTime;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
