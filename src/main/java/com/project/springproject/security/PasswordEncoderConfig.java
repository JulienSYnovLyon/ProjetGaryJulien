package com.project.springproject.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderConfig {
    private PasswordEncoder encoder;

    public PasswordEncoder getEncoder() {
        return encoder;
    }

    public PasswordEncoderConfig()
    {
        encoder = new BCryptPasswordEncoder(11);
    }
}

