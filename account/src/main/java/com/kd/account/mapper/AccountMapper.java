package com.kd.account.mapper;

import com.kd.account.dtos.AccountResponse;
import com.kd.account.dtos.CreateAccountRequest;
import com.kd.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity(CreateAccountRequest request) {
        return Account.builder()
                .accountHolderName(request.accountHolderName())
                .accountType(request.accountType())
                .accountNumber(request.accountNumber())
                .balance(request.balance())
                .build();
    }
    public AccountResponse toResponse(Account account) {

        return new AccountResponse(
                account.getId(),
                account.getAccountHolderName(),
                account.getAccountType(),
                account.getAccountNumber(),
                account.getBalance()
        );
    }

}
