package com.vinicius.sinance.controller;

import com.vinicius.sinance.controller.docs.AccountControllerDocs;
import com.vinicius.sinance.dto.account.AccountRequest;
import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.dto.account.BalanceDTO;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController implements AccountControllerDocs {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll(Authentication authentication) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return new ResponseEntity<>(accountService.findAll(user), HttpStatus.OK);
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BalanceDTO> findBalance(Authentication authentication, @PathVariable UUID accountId) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return new ResponseEntity<>(accountService.findBalanceByAccountId(user, accountId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AccountResponse> create(Authentication authentication, @RequestBody @Validated AccountRequest request) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return new ResponseEntity<>(accountService.save(user, request), HttpStatus.CREATED);
    }

}
