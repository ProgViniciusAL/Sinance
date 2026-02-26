package com.vinicius.sinance.controller;

import com.vinicius.sinance.dto.transaction.TransactionRequest;
import com.vinicius.sinance.dto.transaction.TransactionResponse;
import com.vinicius.sinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionResponse> transaction(@RequestBody TransactionRequest transactionRequest){



        return new ResponseEntity<TransactionResponse>(transactionService.create(transactionRequest), HttpStatus.OK);
    }

}
