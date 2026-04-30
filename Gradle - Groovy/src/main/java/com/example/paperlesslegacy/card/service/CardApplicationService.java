package com.example.paperlesslegacy.card.service;

import com.example.paperlesslegacy.card.dto.CardApplicationCreateRequest;
import com.example.paperlesslegacy.card.dto.CardApplicationCreateResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CardApplicationService {

    public CardApplicationCreateResponse create(CardApplicationCreateRequest request) {
        return new CardApplicationCreateResponse(
                UUID.randomUUID().toString(),
                request.getCustomerName(),
                request.getPhoneNumber(),
                request.getBirthDate(),
                request.getCardProductCode(),
                "TEMPORARY_SAVED",
                LocalDateTime.now()
        );
    }
}