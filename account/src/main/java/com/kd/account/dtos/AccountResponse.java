package com.kd.account.dtos;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,

        String accountHolderName,

        String accountType,

        String accountNumber,

        BigDecimal balance
) {
}
