package com.vinicius.sinance.controller;

import com.vinicius.sinance.dto.account.AccountRequest;
import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.service.AccountService;
import com.vinicius.sinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll() {
        return new ResponseEntity<List<AccountResponse>>(accountService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AccountResponse> create(@RequestBody @Validated AccountRequest request) {
        return new ResponseEntity<AccountResponse>(accountService.save(request), HttpStatus.CREATED);
    }

}
