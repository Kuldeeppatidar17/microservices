package com.kd.cards.mapper;

import com.kd.cards.dto.CardDto;
import com.kd.cards.entity.Card;


public class Mapper {

    public static CardDto mapToDto(Card card){
        return new CardDto(card.getId(),card.getCardNumber(),card.getCardType(),card.getCreditLimit(),card.getAvailableAmount(),card.getMobileNumber());
    }

    public static Card mapToEntity(CardDto dto){
        return Card.builder()
                .cardNumber(dto.cardNumber())
                .cardType(dto.cardType())
                .creditLimit(dto.creditLimit())
                .availableAmount(dto.availableAmount())
                .mobileNumber(dto.mobileNumber())
                .build();
    }
}
