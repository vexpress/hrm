package com.bz.hrm.controller;

import com.bz.hrm.entity.RoleEntity;
import com.bz.hrm.entity.UserEntity;
import com.bz.hrm.repository.RoleRepository;
import com.bz.hrm.repository.UserRepository;
import com.bz.hrm.security.jwt.JwtUtils;
import com.bz.hrm.security.services.UserDetailsImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    // SignIn and SignUp endpoints
}
