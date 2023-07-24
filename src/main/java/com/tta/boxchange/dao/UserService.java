package com.tta.boxchange.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.services.MailService;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	
	public String updateUser(User user) {
		@SuppressWarnings("unused")
		User userUpdate = userRepository.findById(user.getId()).get();
		userUpdate = userRepository.saveAndFlush(user);
		return "upadate avec succes";
	}
	
	

}
