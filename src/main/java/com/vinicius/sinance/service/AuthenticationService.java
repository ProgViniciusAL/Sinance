package com.vinicius.sinance.service;

import com.vinicius.sinance.dto.auth.LoginRequest;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        return (UserEntity) authentication.getPrincipal();
    }

    public String login(LoginRequest loginRequest){
        var usernameAndPassword = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        var authentication = authenticationManager.authenticate(usernameAndPassword);

        return tokenService.generateToken((UserEntity) Objects.requireNonNull(authentication.getPrincipal()));
    }

}
