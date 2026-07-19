package com.kd.account.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountResponse(
        Long id,

        String accountHolderName,

        String accountType,

        String accountNumber,

        BigDecimal balance,
        LocalDateTime createdAt,
        String createdBy,

        LocalDateTime updatedAt,
        String updatedBy
) {
}
