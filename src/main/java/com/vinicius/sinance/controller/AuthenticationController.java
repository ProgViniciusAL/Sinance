package com.vinicius.sinance.controller;

import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.dto.auth.LoginRequest;
import com.vinicius.sinance.dto.auth.LoginResponse;
import com.vinicius.sinance.dto.auth.RegisterRequest;
import com.vinicius.sinance.dto.auth.RegisterResponse;
import com.vinicius.sinance.security.TokenService;
import com.vinicius.sinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var usernameAndPassword = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        var authentication = authenticationManager.authenticate(usernameAndPassword);

        var token = tokenService.generateToken((UserEntity) Objects.requireNonNull(authentication.getPrincipal()));

        return new ResponseEntity<LoginResponse>(new LoginResponse(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(registerRequest.username());
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(passwordEncoder.encode(registerRequest.password()));

        userService.save(newUser);

        return new ResponseEntity<RegisterResponse>(new RegisterResponse("Registered successfully"), HttpStatus.CREATED);
    }

}
