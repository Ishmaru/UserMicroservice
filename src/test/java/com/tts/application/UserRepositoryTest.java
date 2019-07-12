package com.tts.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.application.model.User;
import com.tts.application.repository.UserRepository;
@RunWith(SpringRunner.class)
@DataJpaTest


public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;
	
	
	@Test
	public void givenUser_UserIsSaved() {
		User bob = new User(1L, 40, "Bob");
		userRepository.save(bob);
		userRepository.findUserById(bob.getId());
		assertThat("Bob").isEqualTo(bob.getName());
	}

}
