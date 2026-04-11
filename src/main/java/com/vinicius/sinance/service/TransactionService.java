package com.vinicius.sinance.service;

import com.vinicius.sinance.exception.AccountNotFound;
import com.vinicius.sinance.mapper.TransactionMapper;
import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.TransactionEntity;
import com.vinicius.sinance.dto.transaction.TransactionRequest;
import com.vinicius.sinance.dto.transaction.TransactionResponse;
import com.vinicius.sinance.model.UserEntity;
import com.vinicius.sinance.repository.AccountRepository;
import com.vinicius.sinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    public TransactionResponse create(UserEntity authenticatedUser, TransactionRequest request) {
        TransactionEntity transaction = new TransactionEntity();

        AccountEntity account = accountRepository.findByIdAndUserId(request.accountId(), authenticatedUser.getId()).orElseThrow(() -> new AccountNotFound("Account not found"));

        transaction.setAccount(account);
        transaction.setAmount(request.amount());
        transaction.setType(request.transaction_type());
        transaction.setDescription(request.description());
        transaction.setCreatedAt(LocalDateTime.now());

        return TransactionMapper.mapToTransactionResponse(repository.save(transaction));
    }

    public List<TransactionResponse> findAll(UserEntity authenticatedUser, UUID accountId) {
        AccountEntity account = accountRepository.findByIdAndUserId(accountId, authenticatedUser.getId()).orElseThrow(() -> new AccountNotFound("Account not found"));
        return TransactionMapper.mapToTransactionResponse(repository.findAllByAccountId(account.getId()));
    }

}
