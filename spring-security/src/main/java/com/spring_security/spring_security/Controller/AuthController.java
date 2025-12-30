package com.spring_security.spring_security.Controller;


import com.spring_security.spring_security.dto.LoginDTO;
import com.spring_security.spring_security.dto.SignUpDTO;
import com.spring_security.spring_security.dto.UserDTO;
import com.spring_security.spring_security.services.AuthService;
import com.spring_security.spring_security.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO , HttpServletResponse response){
         String token =    authService.login(loginDTO);

        Cookie  cookie = new Cookie("token" , token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

         return   ResponseEntity.ok(token);
    }

}
