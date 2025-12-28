package com.vinicius.sinance.model.dto;

import com.vinicius.sinance.enums.AccountType;

import java.math.BigDecimal;

public record AccountRequest(String name, BigDecimal current_balance, AccountType account_type) {
}
