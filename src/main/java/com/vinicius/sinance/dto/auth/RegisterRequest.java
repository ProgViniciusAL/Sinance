package com.vinicius.sinance.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(@NotBlank
                              @Size(max = 50)
                              @Pattern(regexp = "^[a-zA-Z0-9 à-úÀ-Ú]+$", message = "Caracteres especiais não permitidos") String username,
                              String email,
                              String password) {
}
