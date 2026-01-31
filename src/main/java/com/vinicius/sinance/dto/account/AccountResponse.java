package com.vinicius.sinance.dto.account;

import com.vinicius.sinance.enums.AccountType;

import java.math.BigDecimal;

public record AccountResponse(String name, BigDecimal currentBalance, AccountType accountType, Boolean isActive) {

}
