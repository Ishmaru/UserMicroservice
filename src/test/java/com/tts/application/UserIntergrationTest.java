package com.tts.application;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tts.application.UserMicroserviceApplication;
import com.tts.application.model.User;
import com.tts.application.repository.UserRepository;

import junit.framework.TestCase;
@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = WebEnvironment.MOCK,
	classes = UserMicroserviceApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties" )
public class UserIntergrationTest extends TestCase {

	User bob;
	
	@Autowired
    private UserRepository repository;
	
	@Autowired
	private MockMvc mvc;
	
	@Before
	public void setUp() {
		bob = new User(40, "Bob");
		repository.save(bob);

	}

	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void givenUser_getUser_returnsUser() throws Exception {
		Long userId = bob.getId();
		
		mvc.perform(get("/api/user/" + userId)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(userId));

	}
	
}
