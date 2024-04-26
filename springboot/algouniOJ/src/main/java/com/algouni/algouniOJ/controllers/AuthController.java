package com.algouni.algouniOJ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algouni.algouniOJ.models.User;
import com.algouni.algouniOJ.services.UserService;

// TODO after basic testing of Platform without User authentication
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    // @PostMapping("/login")
    // public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginInfo) {
    // User user = userService.validateLogin(loginInfo.getUsername(),
    // loginInfo.getPassword());
    // if (user != null) {
    // // Generate JWT or use other authentication mechanism
    // return ResponseEntity.ok("Login successful");
    // } else {
    // return ResponseEntity.badRequest().body("Invalid credentials");
    // }
    // }
}
