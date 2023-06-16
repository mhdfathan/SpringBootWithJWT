package com.Mhdfathan.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mhdfathan.model.UserEntity;

public interface UserLoginRepository extends JpaRepository<UserEntity, String>{
	
	UserEntity findByUsernameAndPassword(String username,String Password);
	UserEntity findByUsernameAndToken(String username,String Password);

}
