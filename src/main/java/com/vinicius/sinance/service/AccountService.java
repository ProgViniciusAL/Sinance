package com.vinicius.sinance.service;

import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.model.dto.AccountRequest;
import com.vinicius.sinance.model.dto.AccountResponse;
import com.vinicius.sinance.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private IAccountRepository repository;

    public List<AccountResponse> findAll() {
        return ObjectMapper.parseListObject(repository.findAll(), AccountResponse.class);
    }

    public AccountResponse create(AccountRequest request) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(request.name());
        accountEntity.setCurrent_balance(request.current_balance());
        accountEntity.setAccount_type(request.account_type());

        return ObjectMapper.parseObject(repository.save(accountEntity), AccountResponse.class);
    }

    public void delete(UUID accountId) {
        AccountEntity findedAccount = repository.findById(accountId).orElse(null);
        if(findedAccount != null) {
            repository.delete(findedAccount);
        }
    }

}
