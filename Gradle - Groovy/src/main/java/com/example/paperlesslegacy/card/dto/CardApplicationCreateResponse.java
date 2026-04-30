package com.example.paperlesslegacy.card.dto;

import java.time.LocalDateTime;

public class CardApplicationCreateResponse {

    private final String applicationId;
    private final String customerName;
    private final String phoneNumber;
    private final String birthDate;
    private final String cardProductCode;
    private final String status;
    private final LocalDateTime createdAt;

    public CardApplicationCreateResponse(
            String applicationId,
            String customerName,
            String phoneNumber,
            String birthDate,
            String cardProductCode,
            String status,
            LocalDateTime createdAt
    ) {
        this.applicationId = applicationId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.cardProductCode = cardProductCode;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCardProductCode() {
        return cardProductCode;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}