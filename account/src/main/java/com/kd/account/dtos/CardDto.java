package com.kd.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CardDto(
        Long cardId,
        @NotBlank(message = "Card number is required")
        String cardNumber,
        @NotBlank(message = "Card type is required")
        String cardType,
        @NotNull(message = "Credit limit is required")
        @Positive(message = "Credit limit must be greater than zero")
        Double creditLimit,
        @NotNull(message = "Available amount is required")
        @Positive(message = "Available amount must be greater than zero")
        Double availableAmount,

        @NotNull(message = "Mobile number is required")
        Long mobileNumber
) {
}
