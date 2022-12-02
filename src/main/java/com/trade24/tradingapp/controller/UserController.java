package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public void addUser(User user) {

    }

    public void updateUser(Long id, User user) {

    }
    public void deleteUser(Long id) {

    }
}
