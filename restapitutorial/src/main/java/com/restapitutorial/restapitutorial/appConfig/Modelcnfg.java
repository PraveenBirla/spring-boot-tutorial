package com.restapitutorial.restapitutorial.appConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Modelcnfg {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
