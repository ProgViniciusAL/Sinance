package com.vinicius.sinance.dto.account;

import com.vinicius.sinance.enums.AccountType;

public record AccountResponse(java.util.UUID id, String name, AccountType accountType) {

}
