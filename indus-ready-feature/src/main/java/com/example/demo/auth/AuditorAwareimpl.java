package com.example.demo.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareimpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("praveen Birla");
    }
}
