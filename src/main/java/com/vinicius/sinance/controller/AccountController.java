package com.vinicius.sinance.controller;

import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.dto.AccountRequest;
import com.vinicius.sinance.model.dto.AccountResponse;
import com.vinicius.sinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public List<AccountResponse> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public AccountResponse create(@RequestBody AccountRequest request) {
        return service.create(request);
    }

}
