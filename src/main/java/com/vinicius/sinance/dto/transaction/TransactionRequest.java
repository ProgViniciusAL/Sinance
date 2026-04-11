package com.vinicius.sinance.dto.transaction;

import com.vinicius.sinance.enums.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(UUID accountId, BigDecimal amount, TransactionType transaction_type, String description) {
}
