package com.spring_security.spring_security.Controller;


import com.spring_security.spring_security.dto.LoginDTO;
import com.spring_security.spring_security.dto.LoginResponseDto;
import com.spring_security.spring_security.dto.SignUpDTO;
import com.spring_security.spring_security.dto.UserDTO;
import com.spring_security.spring_security.services.AuthService;
import com.spring_security.spring_security.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO =  userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDTO loginDTO , HttpServletResponse response){
        LoginResponseDto loginResponseDto = authService.login(loginDTO);

        Cookie  cookie = new Cookie("refreshtoken" , loginResponseDto.getAccessToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

         return   ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/refresh")
    public  ResponseEntity<LoginResponseDto> refresh(HttpServletRequest  request){
       String refreshtoken = Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshtoken".equals(cookie))
                .findFirst()
                .map( cookie -> cookie.getValue())
                .orElseThrow( () -> new AuthenticationServiceException("refresh token not found")
                );

        LoginResponseDto loginResponseDto = authService.refreshtoken(refreshtoken);

        return ResponseEntity.ok(loginResponseDto);
    }
}
