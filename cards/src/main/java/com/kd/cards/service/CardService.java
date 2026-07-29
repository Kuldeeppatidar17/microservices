package com.kd.cards.service;

import com.kd.cards.dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto createCard(CardDto cardDto);

    CardDto getCardById(Long cardId);

    List<CardDto> getAllCards();

    CardDto updateCard(Long cardId, CardDto cardDto);

    void deleteCard(Long cardId);
}
