package com.vinicius.sinance.controller;

import com.vinicius.sinance.dto.transaction.TransactionRequest;
import com.vinicius.sinance.dto.transaction.TransactionResponse;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionResponse> create(Authentication authentication, @RequestBody TransactionRequest transactionRequest){
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return new ResponseEntity<TransactionResponse>(transactionService.create(user, transactionRequest), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionResponse>> findAll(Authentication authentication, @PathVariable UUID accountId){
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return new ResponseEntity<List<TransactionResponse>>(transactionService.findAll(user, accountId), HttpStatus.OK);
    }

}
