package com.vinicius.sinance.service;

import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private IAccountRepository accountRepository;

    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

}
