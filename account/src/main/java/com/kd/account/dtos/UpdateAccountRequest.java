package com.kd.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateAccountRequest(
        @NotBlank
        String accountHolderName,

        @NotBlank
        String accountType,

        @PositiveOrZero
        BigDecimal balance
) {
}
