package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.repository.UserRepository;
import com.trade24.tradingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User store(User user) {
        // TODO: hash password before store
        return userRepository.save(user);
    }
}
