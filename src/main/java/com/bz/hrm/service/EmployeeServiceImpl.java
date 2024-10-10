package com.bz.hrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.bz.hrm.entity.EmployeeEntity;
import com.bz.hrm.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;  // Inject EmployeeRepository
    
    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch all users from the database
    }
    
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        // Save employee entity to the database
        return employeeRepository.save(employee);
    }

	@Override
	public EmployeeEntity getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeEntity updateEmployee(Long id, EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
	}

    // Implement other methods...
}
