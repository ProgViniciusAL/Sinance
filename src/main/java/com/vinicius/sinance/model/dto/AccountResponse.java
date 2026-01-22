package com.vinicius.sinance.model.dto;

import com.vinicius.sinance.enums.AccountType;
import com.vinicius.sinance.model.UserEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String name;
    private BigDecimal current_balance;
    private AccountType account_type;
}
