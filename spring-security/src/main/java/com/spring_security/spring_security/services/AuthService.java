package com.spring_security.spring_security.services;

import com.spring_security.spring_security.dto.LoginDTO;
import com.spring_security.spring_security.dto.LoginResponseDto;
import com.spring_security.spring_security.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private  final JwtService jwtService;
   private final UserService userService;
   private final SessionService sessionService;


    public LoginResponseDto login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
         sessionService.generateNewSession(user,refreshToken);
        LoginResponseDto loginResponseDto = new LoginResponseDto(user.getId() , accessToken , refreshToken);

        return loginResponseDto;
    }

    public LoginResponseDto refreshtoken(String refreshtoken) {

        Long userId = jwtService.getUserIdFromToken(refreshtoken);
        sessionService.validateSession(refreshtoken);
        User user = userService.getUserById(userId);

        String accessToken = jwtService.generateAccessToken(user);

          return  new LoginResponseDto(user.getId() , accessToken ,refreshtoken );
    }
}
