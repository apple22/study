package com.example.paperlesslegacy.card.controller;

import com.example.paperlesslegacy.card.dto.CardApplicationCreateRequest;
import com.example.paperlesslegacy.card.dto.CardApplicationCreateResponse;
import com.example.paperlesslegacy.card.service.CardApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/card-applications")
public class CardApplicationController {

    private final CardApplicationService cardApplicationService;

    public CardApplicationController(CardApplicationService cardApplicationService) {
        this.cardApplicationService = cardApplicationService;
    }

    @PostMapping
    public ResponseEntity<CardApplicationCreateResponse> create(
            @Valid @RequestBody CardApplicationCreateRequest request
    ) {
        CardApplicationCreateResponse response = cardApplicationService.create(request);
        return ResponseEntity.ok(response);
    }
}