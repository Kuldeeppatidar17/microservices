package com.kd.account.service;

import com.kd.account.dtos.AccountResponse;
import com.kd.account.dtos.CreateAccountRequest;
import com.kd.account.dtos.CustomerDtlsDto;
import com.kd.account.dtos.UpdateAccountRequest;

import java.util.List;

public interface AccountService {

    AccountResponse create(CreateAccountRequest request);

    AccountResponse getById(Long id);

    List<AccountResponse> getAll();

    AccountResponse update(Long id, UpdateAccountRequest request);

    void delete(Long id);

    CustomerDtlsDto getCustomerDtls(String mobileNumber);
}
