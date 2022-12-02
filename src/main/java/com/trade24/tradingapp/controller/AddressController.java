package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Address;
import com.trade24.tradingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    Address getById(Long id) {
        return null;
    }

    void deleteById(Long id) {

    }

    void updateAddress(Long id, Address address) {

    }

    Address createAddress(Address address) {
        return null;
    }
}
