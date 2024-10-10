package com.bz.hrm.service;

import com.bz.hrm.entity.UserEntity;
import java.util.List;

public interface UserService {
	UserEntity saveUser(UserEntity user);
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}
