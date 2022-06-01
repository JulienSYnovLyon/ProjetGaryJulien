package com.project.springproject.security;

import com.project.springproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired
 private UserService userService;
 @Autowired
 private PasswordEncoderConfig passwordEncoderConfig;
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(userService).passwordEncoder(passwordEncoderConfig.getEncoder());
 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
  http.authorizeRequests()
          .antMatchers("/api", "/api/", "/swagger-ui/" , "/users/update-password").hasRole("admin")
          .antMatchers("/index.html" , "/").permitAll()
          .anyRequest().authenticated()
          .and().httpBasic();
 }
}