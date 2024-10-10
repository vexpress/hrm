package com.bz.hrm.security.services;

import com.bz.hrm.entity.UserEntity;
import com.bz.hrm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
    	UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        return UserDetailsImpl.build(user);
    }
}
