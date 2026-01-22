package com.vinicius.sinance.service;

import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.repository.IUserEntityRepository;
import com.vinicius.sinance.security.dto.RegisterRequest;
import com.vinicius.sinance.security.dto.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserEntityRepository userEntityRepository;



}
