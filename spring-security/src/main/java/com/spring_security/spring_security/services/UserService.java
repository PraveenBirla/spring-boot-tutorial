package com.spring_security.spring_security.services;

import com.spring_security.spring_security.dto.LoginDTO;
import com.spring_security.spring_security.dto.SignUpDTO;
import com.spring_security.spring_security.dto.UserDTO;
import com.spring_security.spring_security.entities.User;
import com.spring_security.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("acked"));
    }


    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("jadedness"));
    }
    public UserDTO signUp(SignUpDTO signUpDTO) {

          Optional<User> user  = userRepository.findByEmail(signUpDTO.getEmail());
          if(user.isPresent()){
              throw new BadCredentialsException("user with email already present");
          }

          User toBeCreated = modelMapper.map(signUpDTO , User.class);
          toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
          User savedUser = userRepository.save(toBeCreated);
          return modelMapper.map(savedUser , UserDTO.class);

    }


}
