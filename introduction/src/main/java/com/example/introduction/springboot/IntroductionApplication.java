package com.example.introduction.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionApplication implements CommandLineRunner {

//    @Autowired // dependencies injection
//    Apple obj;
//
//    @Autowired // dependencies injection
//    Apple obj1;

    @Autowired
    DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}
 
    @Override
    public void run(String[] args){

        System.out.println(dbService.getData());
//        obj.eatApple();
//        obj1.eatApple();
    }

}
