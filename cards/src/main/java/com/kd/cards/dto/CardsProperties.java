package com.kd.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record CardsProperties(
        String message,
        Map<String,Object> contactInfo,
        List<String> onCallSupport
) {
}
