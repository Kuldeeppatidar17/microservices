package com.kd.cards.service;

import com.kd.cards.constants.MessageConstants;
import com.kd.cards.dto.CardDto;
import com.kd.cards.entity.Card;
import com.kd.cards.exceptions.DuplicateResourceException;
import com.kd.cards.exceptions.ResourceNotFoundException;
import com.kd.cards.mapper.Mapper;
import com.kd.cards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Override
    public CardDto createCard(CardDto cardDto) {
        if (cardRepository.existsByCardNumber(cardDto.cardNumber())) {
            throw new DuplicateResourceException(
                    MessageConstants.CARD_ALREADY_EXISTS);
        }

        Card savedCard = cardRepository.save(Mapper.mapToEntity(cardDto));

        return Mapper.mapToDto(savedCard);
    }

    @Override
    @Transactional(readOnly = true)
    public CardDto getCardById(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                MessageConstants.CARD_NOT_FOUND));

        return Mapper.mapToDto(card);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(Mapper::mapToDto)
                .toList();
    }

    @Override
    public CardDto updateCard(Long cardId, CardDto cardDto) {
        Card existingCard = cardRepository.findById(cardId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                MessageConstants.CARD_NOT_FOUND));

        existingCard.setCardType(cardDto.cardType());
        existingCard.setCreditLimit(cardDto.creditLimit());
        existingCard.setAvailableAmount(cardDto.availableAmount());
        existingCard.setMobileNumber(cardDto.mobileNumber());

        Card updatedCard = cardRepository.save(existingCard);

        return Mapper.mapToDto(updatedCard);
    }

    @Override
    public void deleteCard(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                MessageConstants.CARD_NOT_FOUND));

        cardRepository.delete(card);
    }
}
