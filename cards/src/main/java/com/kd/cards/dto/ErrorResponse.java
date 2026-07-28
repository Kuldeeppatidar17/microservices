package com.kd.cards.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        boolean success,
        int status,
        String message,
        LocalDateTime timeStamp,
        Map<String,String> errors
) {
}
