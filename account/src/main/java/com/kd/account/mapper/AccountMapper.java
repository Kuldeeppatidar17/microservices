package com.kd.account.mapper;

import com.kd.account.dtos.AccountResponse;
import com.kd.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
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
