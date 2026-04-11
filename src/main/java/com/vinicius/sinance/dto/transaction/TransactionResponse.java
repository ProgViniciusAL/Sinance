package com.vinicius.sinance.dto.transaction;

import com.vinicius.sinance.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponse(UUID id, String description, TransactionType transactionType, BigDecimal amount, LocalDateTime createdAt) {

}
