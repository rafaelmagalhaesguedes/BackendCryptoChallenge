package com.rafa.cryptography.controller.dto;

public record TransactionCreationDto(
        String userDocument,
        String creditCardToken,
        Long value
) {
}
