package com.example.paperlesslegacy.card.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CardApplicationCreateRequest {

    @NotBlank(message = "고객명은 필수입니다.")
    private String customerName;

    @NotBlank(message = "휴대폰 번호는 필수입니다.")
    @Pattern(
            regexp = "^01[0-9]-?\\d{3,4}-?\\d{4}$",
            message = "휴대폰 번호 형식이 올바르지 않습니다."
    )
    private String phoneNumber;

    @NotBlank(message = "생년월일은 필수입니다.")
    @Pattern(
            regexp = "^\\d{8}$",
            message = "생년월일은 yyyyMMdd 형식이어야 합니다."
    )
    private String birthDate;

    @NotBlank(message = "카드 상품 코드는 필수입니다.")
    private String cardProductCode;

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
}