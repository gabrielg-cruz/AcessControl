package com.accesscontrol.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_logs")
public class AccessLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDateTime accessTime;

    @Column(nullable = false)
    private LocalDateTime exitTime;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Area getArea() {
        return area;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}