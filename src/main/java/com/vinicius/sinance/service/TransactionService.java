package com.vinicius.sinance.service;

import com.vinicius.sinance.mapper.ObjectMapper;
import com.vinicius.sinance.model.TransactionEntity;
import com.vinicius.sinance.model.dto.TransactionRequest;
import com.vinicius.sinance.model.dto.TransactionResponse;
import com.vinicius.sinance.repository.IAccountRepository;
import com.vinicius.sinance.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private ITransactionRepository repository;

    @Autowired
    private IAccountRepository accountRepository;

    public TransactionResponse create(TransactionRequest request) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(request.amount());
        transaction.setType(request.transaction_type());
        transaction.setDescription(request.description());

        return ObjectMapper.parseObject(repository.save(transaction), TransactionResponse.class);
    }
}
