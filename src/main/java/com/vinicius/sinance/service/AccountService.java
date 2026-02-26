package com.vinicius.sinance.service;

import com.vinicius.sinance.exception.AccountNotFound;
import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.dto.account.AccountRequest;
import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.repository.AccountRepository;
import com.vinicius.sinance.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private AuthenticationService authService;

    public List<AccountResponse> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity authenticatedUser = (UserEntity) authentication.getPrincipal();

        return ObjectMapper.parseListObject(accountRepository.findAccountEntitiesByUser(authenticatedUser), AccountResponse.class);
    }

    public AccountResponse getAccountById(UUID accountId) {
        UserEntity currentUser = authService.getCurrentUser();
        assert currentUser != null;

        return ObjectMapper.parseObject(accountRepository.findByIdAndUserId(accountId, currentUser.getId()).orElseThrow(() -> new AccountNotFound("")), AccountResponse.class)
    }

    public AccountResponse save(AccountRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity authenticatedUser = userEntityRepository.getUserEntityByEmail(authentication.getName());

        AccountEntity newAccount = new AccountEntity();
        newAccount.setName(request.name());
        newAccount.setAccountType(request.accountType());
        newAccount.setCurrentBalance(request.currentBalance());
        newAccount.setUser(authenticatedUser);

        return ObjectMapper.parseObject(accountRepository.save(newAccount), AccountResponse.class);
    }

    public void delete(UUID accountId) {
        AccountEntity findedAccount = accountRepository.findById(accountId).orElseThrow(null);
        accountRepository.delete(findedAccount);
    }

}
