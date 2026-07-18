package com.kd.account.dtos;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        boolean success,

        int status,

        String message,

        LocalDateTime timestamp,

        T data
) {
}
