package com.example.virus.config;

import com.example.virus.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsServiceImpl userDetailsService;
    private JwtAuthenticationFiter jwtAuthenticationFiter;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, JwtAuthenticationFiter jwtAuthenticationFiter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFiter = jwtAuthenticationFiter;
    }


}
