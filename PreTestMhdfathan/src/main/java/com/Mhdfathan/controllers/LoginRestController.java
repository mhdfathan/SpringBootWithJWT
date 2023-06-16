package com.Mhdfathan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mhdfathan.Services.UserLoginService;
import com.Mhdfathan.configs.JwtUtil;
import com.Mhdfathan.model.UserEntity;

@RestController
@RequestMapping(value = "/api/login")
public class LoginRestController {

	@Autowired
	private UserLoginService loginService;
	
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/loginUser")
    public String login(@RequestBody UserEntity request) {
    	UserEntity users = loginService.findUsername(request);
    	if (users.getUsername()!="" && users.getPassword()!="") {
    		String token = jwtUtil.generateToken(request.getUsername());
    		System.out.println(token);
    		request.setToken(token);
    		loginService.saveToken(request);
    		return "Login Successfull";
    	}else {
    		return "Username or Password is Wrong";
    	}
    }
}
