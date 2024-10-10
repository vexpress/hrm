package com.bz.hrm.controller;

import com.bz.hrm.entity.UserEntity;
import com.bz.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // CRUD endpoints for User
}
