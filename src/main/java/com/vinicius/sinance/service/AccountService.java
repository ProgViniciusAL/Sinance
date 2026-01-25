package com.vinicius.sinance.service;

import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.model.dto.AccountResponse;
import com.vinicius.sinance.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private IAccountRepository accountRepository;

    public Set<AccountEntity> findAll(UserEntity user) {
        return accountRepository.findAccountEntitiesByUser(user);
    }

    public AccountEntity save(AccountEntity account) {
        return accountRepository.save(account);
    }

    public void delete(UUID accountId) {
        AccountEntity findedAccount = accountRepository.findById(accountId).orElseThrow(null);
        accountRepository.delete(findedAccount);
    }

}
