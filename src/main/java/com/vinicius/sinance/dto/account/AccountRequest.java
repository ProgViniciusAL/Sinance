package com.vinicius.sinance.dto.account;

import com.vinicius.sinance.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AccountRequest(@NotBlank
                             @Size(max = 50)
                             @Pattern(regexp = "^[a-zA-Z0-9 à-úÀ-Ú]+$", message = "Caracteres especiais não permitidos") String name,
                             BigDecimal currentBalance,
                             AccountType accountType) {
}
