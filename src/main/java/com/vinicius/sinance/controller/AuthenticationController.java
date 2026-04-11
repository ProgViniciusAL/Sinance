package com.vinicius.sinance.controller;

import com.vinicius.sinance.dto.auth.LoginRequest;
import com.vinicius.sinance.dto.auth.LoginResponse;
import com.vinicius.sinance.dto.auth.RegisterRequest;
import com.vinicius.sinance.dto.auth.RegisterResponse;
import com.vinicius.sinance.service.AuthenticationService;
import com.vinicius.sinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(new LoginResponse(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
        return new ResponseEntity<RegisterResponse>(new RegisterResponse("Registered successfully"), HttpStatus.CREATED);
    }

}
