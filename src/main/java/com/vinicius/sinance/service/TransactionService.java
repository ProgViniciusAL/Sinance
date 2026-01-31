package com.vinicius.sinance.service;

import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.TransactionEntity;
import com.vinicius.sinance.dto.transaction.TransactionRequest;
import com.vinicius.sinance.dto.transaction.TransactionResponse;
import com.vinicius.sinance.repository.AccountRepository;
import com.vinicius.sinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    public TransactionResponse create(TransactionRequest request) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(request.amount());
        transaction.setType(request.transaction_type());
        transaction.setDescription(request.description());

        return ObjectMapper.parseObject(repository.save(transaction), TransactionResponse.class);
    }
}
