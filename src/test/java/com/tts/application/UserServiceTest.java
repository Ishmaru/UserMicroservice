package com.tts.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.application.model.User;
import com.tts.application.repository.UserRepository;
import com.tts.application.service.UserServiceImpl;
import com.tts.application.service.UserServiceInt;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Configuration
	static class ServiceConfiguration{
		@Bean
		public UserServiceInt configuration(){
			return new UserServiceImpl();
		}
	}
	
	@Autowired
	UserServiceImpl userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	public void test() {
		User bob = new User(1L, 40, "Bob");
		Mockito.when(userRepository.findUserById(bob.getId())).thenReturn(bob);
		
		User found = userService.findUserById(bob.getId());
		
		assertThat(bob).isEqualToComparingFieldByField(found);
	}

}
