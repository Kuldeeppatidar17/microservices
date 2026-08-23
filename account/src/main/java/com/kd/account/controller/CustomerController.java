package com.kd.account.controller;

import com.kd.account.dtos.ApiResponse;
import com.kd.account.dtos.ApiResponseUtil;
import com.kd.account.dtos.CustomerDtlsDto;
import com.kd.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final AccountService accountService;

    @GetMapping("/{mobileNumber}")
    public ResponseEntity<ApiResponse<CustomerDtlsDto>> getCustomerDetails(@PathVariable("mobileNumber") String mobileNumber){
        log.info("enter into the customer details controller with mobile number : {}",mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(200,"fetched customer details",accountService.getCustomerDtls(mobileNumber)));
    }
}
