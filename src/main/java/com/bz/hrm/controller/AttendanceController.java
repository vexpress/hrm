package com.bz.hrm.controller;

import com.bz.hrm.entity.AttendanceEntity;
import com.bz.hrm.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    
    // Endpoints for sign-in and sign-out
}
