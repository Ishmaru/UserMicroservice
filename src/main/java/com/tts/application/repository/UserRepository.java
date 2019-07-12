package com.tts.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.application.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findUserById(Long id);
	User findUserByName(String name);
	
}
