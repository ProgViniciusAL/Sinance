package com.vinicius.sinance.exception.handler;

import com.vinicius.sinance.dto.exception.ErrorResponse;
import com.vinicius.sinance.exception.AccountNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GeneralExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex, HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(500, "Internal Server Error", request.getRequestURI());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex, HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(401, "Bad Credentials", request.getRequestURI());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleAuthenticationException(UsernameNotFoundException ex, HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(404, "Resource Not Found", request.getRequestURI());
    }

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<?> handleAccountNotFound(AccountNotFound ex, HttpServletRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(404, "Resource Not Found", request.getRequestURI());
    }

    private ResponseEntity<?> buildResponseEntity(int status, String error, String path) {
        ErrorResponse errorResponse = new ErrorResponse(Instant.now(), status, error, "Unexpected error occurred", path);
        return ResponseEntity.status(status).body(errorResponse);
    }

}
