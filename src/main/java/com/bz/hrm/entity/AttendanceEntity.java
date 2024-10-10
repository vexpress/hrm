package com.bz.hrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Data
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime signInTime;
    private LocalDateTime signOutTime;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}
