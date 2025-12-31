package com.spring_security.spring_security.config;


import com.spring_security.spring_security.filter.JwtAuthFilter;
import com.spring_security.spring_security.handlers.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/posts", "/auth/**" , "/home.html").permitAll()
                        .requestMatchers("/posts/1").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf( csrfConfig -> csrfConfig.disable())
                .sessionManagement( sessionConfig -> sessionConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login( oauthConfig -> oauthConfig
                        .failureUrl("/login?error=true")
                        .successHandler(oAuth2SuccessHandler))
        //                .formLogin(Customizer.withDefaults())
        ;


        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService myInMemoUserDetailsService(){
//        UserDetails normalUser= User
//                .withUsername("raven")
//                .password(passwordEncoder().encode("Praveen@123"))
//                .roles("USER")
//                .build();
//
//        UserDetails adminUser = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(normalUser,adminUser);
//    }



    @Bean
    AuthenticationManager authenticationManage(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}
