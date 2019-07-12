package com.tts.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.application.model.User;
import com.tts.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	
}
