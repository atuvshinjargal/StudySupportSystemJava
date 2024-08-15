package com.sss.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sss.test.service.UserService;
import java.util.List;
import com.sss.test.entity.User;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		List<User> list = userService.findAll();
		for (User u : list) {
			System.out.println(u.getUserInfo());
		}
	}

}
