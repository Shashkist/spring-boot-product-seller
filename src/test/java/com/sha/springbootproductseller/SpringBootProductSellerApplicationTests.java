package com.sha.springbootproductseller;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBootProductSellerApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveUser() {
		User user = new User();
		user.setName("ilia");
		user.setUsername("shashkist2");
		user.setPassword("1234");
		user.setCreateTime(LocalDateTime.now());
		user.setRole(Role.USER);
		userRepository.save(user);
	}




}
