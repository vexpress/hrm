package com.bz.hrm.service;

import com.bz.hrm.entity.EmployeeEntity;
import java.util.List;

public interface EmployeeService { 
	EmployeeEntity saveEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getUserById(Long id);
    EmployeeEntity updateEmployee(Long id, EmployeeEntity employee);
    void deleteEmployee(Long id);
}
