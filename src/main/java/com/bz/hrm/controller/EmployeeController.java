package com.bz.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.bz.hrm.entity.EmployeeEntity;
import com.bz.hrm.service.EmployeeService; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("") // Endpoint to get all employees
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees(); // Call the service method
    }
    // CRUD endpoints for Employee
}
