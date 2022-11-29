package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("")
    public User registerNewUser(User user) throws Exception {
        if (user.getEmail() == "") {
            throw new Exception("Add validation for already existing email in db");
        }

        return userService.store(user);
    }
}
