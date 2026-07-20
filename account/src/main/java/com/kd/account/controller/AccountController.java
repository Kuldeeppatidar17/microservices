package com.kd.account.controller;

import com.kd.account.constant.MessageConstants;
import com.kd.account.dtos.*;
import com.kd.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<ApiResponse<AccountResponse>> create(
            @Valid @RequestBody CreateAccountRequest request) {

        log.info("enter into create account controller");

        AccountResponse response=accountService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtil.success(HttpStatus.CREATED.value(), MessageConstants.ACCOUNT_CREATED,response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountResponse>> getById(@PathVariable Long id) {

        log.info("enter into get account controller: {}",id);

        AccountResponse response=accountService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(HttpStatus.OK.value(),MessageConstants.ACCOUNT_FETCHED,response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AccountResponse>>> getAll() {

        log.info("enter into get all account controller:");

        List<AccountResponse> responses=accountService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(HttpStatus.OK.value(),MessageConstants.ACCOUNTS_FETCHED,responses));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAccountRequest request) {

        log.info("enter into update account controller: {}",id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(HttpStatus.OK.value(),MessageConstants.ACCOUNT_UPDATED,accountService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        accountService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(HttpStatus.OK.value(),MessageConstants.ACCOUNT_DELETED));
    }
}
