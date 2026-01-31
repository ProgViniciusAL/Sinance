package com.vinicius.sinance.dto.transaction;

import com.vinicius.sinance.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal amount, TransactionType transaction_type, String description) {
}
