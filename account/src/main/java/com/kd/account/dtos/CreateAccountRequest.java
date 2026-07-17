package com.kd.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank
        String accountHolderName,

        @NotBlank
        String accountType,

        @NotBlank
        String accountNumber,

        @PositiveOrZero
        BigDecimal balance
) {
}
