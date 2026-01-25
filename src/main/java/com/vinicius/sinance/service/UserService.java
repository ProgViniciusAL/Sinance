package com.vinicius.sinance.service;

import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.model.dto.UserResponse;
import com.vinicius.sinance.repository.IUserEntityRepository;
import com.vinicius.sinance.security.dto.RegisterRequest;
import com.vinicius.sinance.security.dto.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserEntityRepository userEntityRepository;

    public UserResponse save(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
        return new UserResponse(userEntity.getUsername());
    }

    public UserEntity getUserByEmail(String email) {
        return userEntityRepository.getUserEntityByEmail(email);
    }

}
