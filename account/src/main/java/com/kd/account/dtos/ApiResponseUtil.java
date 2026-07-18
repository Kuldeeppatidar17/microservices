package com.kd.account.dtos;

import java.time.LocalDateTime;

public final class ApiResponseUtil {
    private ApiResponseUtil() {
    }

    public static <T> ApiResponse<T> success(int status,String message,T data){
        return new ApiResponse<>(true,status,message, LocalDateTime.now(),data);
    }

    public static ApiResponse<Void> success(int status,String message){
        return new ApiResponse<>(true,status,message,LocalDateTime.now(),null);
    }
}
