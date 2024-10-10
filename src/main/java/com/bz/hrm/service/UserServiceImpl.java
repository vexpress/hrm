package com.bz.hrm.service;

import com.bz.hrm.entity.UserEntity;
import com.bz.hrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity updateUser(Long id, UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

    // Implement all methods
}