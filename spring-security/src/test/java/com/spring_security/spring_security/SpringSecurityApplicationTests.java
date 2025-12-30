package com.spring_security.spring_security;

import com.spring_security.spring_security.entities.User;
import com.spring_security.spring_security.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private JwtService jwtService;

	@Test
	void contextLoads() {

        User user = new User(4L  , "Praveen@gmail.com" ,  "Praveen@123");

        String token = jwtService.generateToke(user);

        System.out.println(token);

        Long id = jwtService.getUserIdFromToken(token);

        System.out.println(id);
	}

}
