package com.trade24.tradingapp.repository;

import com.trade24.tradingapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
