package com.vinicius.sinance.service;

import com.vinicius.sinance.dto.auth.RegisterRequest;
import com.vinicius.sinance.dto.auth.RegisterResponse;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.dto.user.UserResponse;
import com.vinicius.sinance.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse save(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
        return new UserResponse(userEntity.getUsername());
    }

    public UserEntity getUserByEmail(String email) {
        return userEntityRepository.getUserEntityByEmail(email);
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        UserEntity newUser = new UserEntity();

        newUser.setUsername(registerRequest.username());
        newUser.setEmail(registerRequest.email());
        newUser.setPassword_hash(passwordEncoder.encode(registerRequest.password()));
        newUser.setCreatedAt(LocalDateTime.now());

        userEntityRepository.save(newUser);

        return new RegisterResponse(newUser.getUsername());
    }

}
