package com.vinicius.sinance.mapper;

import com.vinicius.sinance.dto.transaction.TransactionResponse;
import com.vinicius.sinance.model.TransactionEntity;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    public static TransactionResponse mapToTransactionResponse(TransactionEntity transactionEntity) {
        return new TransactionResponse(
                transactionEntity.getId(),
                transactionEntity.getDescription(),
                transactionEntity.getType(),
                transactionEntity.getAmount(),
                transactionEntity.getCreatedAt()
        );
    }

    public static List<TransactionResponse> mapToTransactionResponse(List<TransactionEntity> accountEntityList) {
        List<TransactionResponse> accountResponseList = new ArrayList<>();
        for (TransactionEntity TransactionEntity : accountEntityList) {
            accountResponseList.add(mapToTransactionResponse(TransactionEntity));
        }
        return accountResponseList;
    }
    
}
