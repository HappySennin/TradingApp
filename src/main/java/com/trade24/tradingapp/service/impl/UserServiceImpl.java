package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.repository.UserRepository;
import com.trade24.tradingapp.service.AddressService;
import com.trade24.tradingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
        this.addressService.createAddress(user.getAddress());
    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
