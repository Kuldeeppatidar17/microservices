package com.kd.account.service.client;

import com.kd.account.dtos.ApiResponse;
import com.kd.account.dtos.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cards")  // name which is used by eureka server
public interface CardsFeignClient {
    // create same method as cards controller as an abstract method
    @GetMapping(value = "/api/v1/cards/card-number/{cardNumber}",consumes = "application/json")
    public ResponseEntity<ApiResponse<CardDto>> getCardById(
            @PathVariable String cardNumber);
}
