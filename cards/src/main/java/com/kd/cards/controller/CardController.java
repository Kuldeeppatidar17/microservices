package com.kd.cards.controller;

import com.kd.cards.constants.MessageConstants;
import com.kd.cards.dto.ApiResponse;
import com.kd.cards.dto.CardDto;
import com.kd.cards.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<ApiResponse<CardDto>> createCard(
            @Valid @RequestBody CardDto cardDto) {

        CardDto savedCard = cardService.createCard(cardDto);

        ApiResponse<CardDto> response = ApiResponse.<CardDto>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message(MessageConstants.CARD_CREATED)
                .data(savedCard)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
