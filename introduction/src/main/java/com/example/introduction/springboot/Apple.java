package com.example.introduction.springboot;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //initialized a bean
//@Scope("prototype")
public class Apple {

    public void eatApple(){
        System.out.println("i am eating a apple");
    }

    @PostConstruct
    void callThisBeforeAppleUsed(){
        System.out.println("creating the apple before use");
    }

    @PreDestroy
    void callThisBeforeDestroye(){
        System.out.println("destroying the bean");
    }
}
