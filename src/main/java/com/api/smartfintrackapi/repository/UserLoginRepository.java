package com.api.smartfintrackapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.smartfintrackapi.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

	UserLogin findByUsername(String userName);

}