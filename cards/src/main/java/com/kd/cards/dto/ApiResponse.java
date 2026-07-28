package com.kd.cards.dto;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        boolean success,
        int status,
        String message,
        LocalDateTime timeStamp,
        T data
) {
}
