package com.jaynius.psvmv1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Securityconfig {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
