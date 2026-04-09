package com.vinicius.sinance.controller.docs;

import com.vinicius.sinance.dto.account.AccountRequest;
import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.dto.account.BalanceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AccountControllerDocs {

    @Operation(summary = "List User Bank Accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Unauthorized")
    })
    ResponseEntity<List<AccountResponse>> findAll(Authentication authentication);

    @Operation(summary = "Get Bank Account Current Balance")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Unauthorized")
    })
    ResponseEntity<BalanceDTO> findBalance(Authentication authentication, @PathVariable UUID accountId);

    @Operation(summary = "Create User Bank Account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Unauthorized")
    })
    ResponseEntity<AccountResponse> create(Authentication authentication, @RequestBody @Validated AccountRequest request);
}
