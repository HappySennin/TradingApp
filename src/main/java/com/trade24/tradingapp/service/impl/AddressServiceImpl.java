package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Address;
import com.trade24.tradingapp.repository.AddressRepository;
import com.trade24.tradingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateAddress(Long id, Address address) {

    }

    @Override
    public Address createAddress(Address address) {
        return null;
    }
}
