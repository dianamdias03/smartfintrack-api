package com.api.smartfintrackapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.api.smartfintrackapi.dtos.CategoryDTO;
import com.api.smartfintrackapi.dtos.UserLoginDTO;
import com.api.smartfintrackapi.model.Category;
import com.api.smartfintrackapi.model.UserLogin;
import com.api.smartfintrackapi.repository.UserLoginRepository;


@Service
public class UserLoginService {
	
	@Autowired
	private UserLoginRepository userRepository;

    public UserLoginDTO registerUser(UserLogin user) {
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(encryptedPassword);
        return convertToDto(userRepository.save(user));
    }

    public UserLogin findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}
	
	public UserLoginDTO convertToDto(UserLogin userLogin) {
		UserLoginDTO dto = new UserLoginDTO();
        dto.setId(userLogin.getId());
        dto.setUsername(userLogin.getUsername());
        return dto;
    }
}
