package com.vinicius.sinance.dto.exception;

import java.io.Serializable;
import java.time.Instant;

public record ErrorResponse(Instant timestamp, Integer status, String error, String message, String path) implements Serializable {
}
