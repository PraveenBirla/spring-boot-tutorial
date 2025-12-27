package com.example.demo.appconfig;


import com.example.demo.auth.AuditorAwareimpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditor")
public class config {

  @Bean
    ModelMapper getModelMapper(){
      return new ModelMapper();
  }

    @Bean
    AuditorAware getAuditor(){
        return new AuditorAwareimpl();
    }
}
