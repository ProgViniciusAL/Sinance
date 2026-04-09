package com.vinicius.sinance.service;

import com.vinicius.sinance.dto.account.BalanceDTO;
import com.vinicius.sinance.exception.AccountNotFound;
import com.vinicius.sinance.mapper.AccountMapper;
import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.dto.account.AccountRequest;
import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.repository.AccountRepository;
import com.vinicius.sinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthenticationService authService;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<AccountResponse> findAll(UserEntity authenticatedUser) {
        return AccountMapper.mapToAccountResponse(accountRepository.findAccountEntitiesByUser(authenticatedUser));
    }

    public AccountResponse getAccountById(UUID accountId) {
        UserEntity currentUser = authService.getCurrentUser();
        assert currentUser != null;
        return ObjectMapper.parseObject(accountRepository.findByIdAndUserId(accountId, currentUser.getId()).orElseThrow(() -> new AccountNotFound("")), AccountResponse.class);
    }

    public AccountResponse save(UserEntity authenticatedUser, AccountRequest request) {
        AccountEntity newAccount = new AccountEntity();
        newAccount.setName(request.name());
        newAccount.setAccountType(request.accountType());
        newAccount.setUser(authenticatedUser);

        return AccountMapper.mapToAccountResponse(accountRepository.save(newAccount));
    }

    public BalanceDTO findBalanceByAccountId(UserEntity authenticatedUser, UUID accountId) {
        AccountEntity account = accountRepository.findByIdAndUserId(accountId, authenticatedUser.getId()).orElseThrow(() -> new AccountNotFound("Account not found"));
        return new BalanceDTO(transactionRepository.findBalanceByAccountId(account.getId()));
    }

    public void delete(UUID accountId) {
        AccountEntity findedAccount = accountRepository.findById(accountId).orElseThrow(() ->  new AccountNotFound("Account not found"));
        accountRepository.delete(findedAccount);
    }

}
