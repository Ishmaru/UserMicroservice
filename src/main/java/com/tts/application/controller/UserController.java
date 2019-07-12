package com.tts.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.application.model.User;
import com.tts.application.service.UserServiceImpl;

@RestController
@RequestMapping(value="/api")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@GetMapping(value="/user/{id}")
	public User getOne(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@PostMapping(value="/user/")
	public User newUser(User user) {
		return userService.saveUser(user);
	}
}
