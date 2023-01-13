package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Address;
import com.trade24.tradingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    Address getById(Long id) {
        return this.addressService.getById(id);
    }

    @DeleteMapping
    void deleteById(Long id) {
        this.addressService.deleteById(id);
    }

    @PutMapping
    void updateAddress(Long id, Address address) {
        this.addressService.updateAddress(id, address);
    }

    @PostMapping
    Address createAddress(Address address) {
        return this.addressService.createAddress(address);
    }
}
