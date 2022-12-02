package com.trade24.tradingapp.service;

import com.trade24.tradingapp.entity.Address;

public interface AddressService {
    Address getById(Long id);
    void deleteById(Long id);
    void updateAddress(Long id, Address address);
    Address createAddress(Address address);
}
