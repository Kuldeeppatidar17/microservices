package com.kd.cards.dto;

import java.time.LocalDateTime;
import java.util.Date;

public final class ApiResponseUtil {

    private ApiResponseUtil(){

    }

    public <T> ApiResponse<T> success(int status,String message, T data){
        return new ApiResponse<>(true,status, message, LocalDateTime.now(),data);
    }

    public ApiResponse<Void> success(int status,String message){
        return new ApiResponse<>(true,status,message,LocalDateTime.now(),null);
    }
}
