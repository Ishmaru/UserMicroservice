package com.tts.application.service;

import com.tts.application.model.User;

public interface UserServiceInt {
	User findUserById(Long id);
	User saveUser(User user);
}
