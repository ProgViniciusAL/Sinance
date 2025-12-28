package com.vinicius.sinance.model.dto;

import com.vinicius.sinance.model.UserEntity;

import java.util.UUID;

public record AccountResponse(String name, UUID userId) {
}
