package com.vinicius.sinance.model.dto;

import com.vinicius.sinance.enums.TransactionType;
import com.vinicius.sinance.model.AccountEntity;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal amount, TransactionType transaction_type, String description) {
}
