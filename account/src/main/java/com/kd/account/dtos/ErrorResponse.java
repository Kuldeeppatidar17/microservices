package com.kd.account.dtos;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        boolean success,

        int status,

        String message,

        LocalDateTime timestamp,

        Map<String, String> errors
) {
}
