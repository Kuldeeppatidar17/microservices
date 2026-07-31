package com.kd.cards.controller;

import com.kd.cards.constants.MessageConstants;
import com.kd.cards.dto.ApiResponse;
import com.kd.cards.dto.CardDto;
import com.kd.cards.dto.CardsProperties;
import com.kd.cards.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {
    private final CardService cardService;
    private final CardsProperties cardsProperties;

    @Autowired
    private Environment environment;

    @PostMapping
    public ResponseEntity<ApiResponse<CardDto>> createCard(
            @Valid @RequestBody CardDto cardDto) {

        CardDto savedCard = cardService.createCard(cardDto);

        ApiResponse<CardDto> response = new ApiResponse(
                true,
                HttpStatus.CREATED.value(),
                MessageConstants.CARD_CREATED,
                LocalDateTime.now(),
                savedCard);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<ApiResponse<CardDto>> getCardById(
            @PathVariable Long cardId) {

        CardDto card = cardService.getCardById(cardId);

        ApiResponse<CardDto> response = new ApiResponse(
                true,
                HttpStatus.OK.value(),
                MessageConstants.CARD_FETCHED,
                LocalDateTime.now(),
                card);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/card-number/{cardNumber}")
    public ResponseEntity<ApiResponse<CardDto>> getCardByNumber(
            @PathVariable String cardNumber) {

        CardDto card = cardService.getCardByNumber(cardNumber);

        ApiResponse<CardDto> response = new ApiResponse(
                true,
                HttpStatus.OK.value(),
                MessageConstants.CARD_FETCHED,
                LocalDateTime.now(),
                card);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CardDto>>> getAllCards() {

        List<CardDto> cards = cardService.getAllCards();

        ApiResponse<List<CardDto>> response = new ApiResponse(
                true,
                HttpStatus.OK.value(),
                MessageConstants.CARD_FETCHED,
                LocalDateTime.now(),
                cards);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<ApiResponse<CardDto>> updateCard(
            @PathVariable Long cardId,
            @Valid @RequestBody CardDto cardDto) {

        CardDto updatedCard = cardService.updateCard(cardId, cardDto);

        ApiResponse<CardDto> response = new ApiResponse(
                true,
                HttpStatus.OK.value(),
                MessageConstants.CARD_UPDATED,
                LocalDateTime.now(),
                updatedCard);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<ApiResponse<Void>> deleteCard(
            @PathVariable Long cardId) {

        cardService.deleteCard(cardId);

        ApiResponse<Void> response = new ApiResponse(
                true,
                HttpStatus.OK.value(),
                MessageConstants.CARD_DELETED,
                LocalDateTime.now(),
                null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/java-version")
    public String getJavaVersion(){
        log.info("java version controller");
        return environment.getProperty("java.home");
    }

    @GetMapping("/contact-info")
    public Map<String, Object> getContactInfo() {
        return cardsProperties.contactInfo();
    }
}
