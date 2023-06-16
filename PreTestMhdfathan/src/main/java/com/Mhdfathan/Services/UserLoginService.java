package com.Mhdfathan.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mhdfathan.Repositories.UserLoginRepository;
import com.Mhdfathan.model.UserEntity;

@Service
public class UserLoginService {
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	public UserEntity findUsername(UserEntity user) {
		return userLoginRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
	
	public void saveToken(UserEntity user) {
		UserEntity users = new UserEntity();
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setToken(user.getToken());
		userLoginRepository.save(users);
	}

}
