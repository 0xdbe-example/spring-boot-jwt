package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController
public class HelloController {
  
  @RequestMapping("/")
  public Jwt helloUser(@AuthenticationPrincipal Jwt jwt) {
    return jwt;
  }

} 
