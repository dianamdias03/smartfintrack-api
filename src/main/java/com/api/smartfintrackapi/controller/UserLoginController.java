package com.api.smartfintrackapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.smartfintrackapi.dtos.UserLoginDTO;
import com.api.smartfintrackapi.model.UserLogin;
import com.api.smartfintrackapi.service.UserLoginService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class UserLoginController {
	
	@Autowired 
	UserLoginService userService;
	
	@PostMapping("/createLogin")
	public UserLoginDTO registerUser(@RequestBody UserLogin user) {
		UserLoginDTO dto = new UserLoginDTO();
        if (!user.getPassword().equals(user.getConfirmPassword())) {
        	dto.setErrorMessage("As senhas não coincidem. Por favor, verifique se a senha e a confirmação da senha são idênticas.");
            dto.setSucessLogin(Boolean.FALSE);
            return dto;
        }
        dto = userService.registerUser(user);
        dto.setSucessLogin(Boolean.TRUE);
        return dto;
    }
	
	@GetMapping("/login")
    public UserLoginDTO login(@RequestParam String userName, @RequestParam String password) {
        UserLogin user = userService.findByUsername(userName);
        UserLoginDTO dto = userService.convertToDto(user);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            dto.setSucessLogin(Boolean.TRUE);
        } else {
        	dto.setErrorMessage("Senha incorreta!");
        	dto.setSucessLogin(Boolean.FALSE);
        }
        return dto;
    }
}
