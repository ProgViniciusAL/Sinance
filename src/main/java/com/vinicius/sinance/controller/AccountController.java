package com.vinicius.sinance.controller;

import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.model.dto.AccountRequest;
import com.vinicius.sinance.model.dto.AccountResponse;
import com.vinicius.sinance.service.AccountService;
import com.vinicius.sinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @GetMapping
    public Set<AccountEntity> findAll() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity authenticatedUser = (UserEntity) authentication.getPrincipal();

        return accountService.findAll(authenticatedUser);
    }

    @PostMapping()
    public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity authenticatedUser = userService.getUserByEmail(authentication.getName());

        AccountEntity newAccount = new AccountEntity();
        newAccount.setName(request.name());
        newAccount.setAccountType(request.accountType());
        newAccount.setCurrentBalance(request.currentBalance());
        newAccount.setUser(authenticatedUser);

        accountService.save(newAccount);

        return new ResponseEntity<AccountResponse>(new AccountResponse("Account has been created sucessfully"), HttpStatus.CREATED);
    }

}
