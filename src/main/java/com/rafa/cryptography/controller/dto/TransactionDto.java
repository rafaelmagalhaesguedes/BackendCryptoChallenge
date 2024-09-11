package com.rafa.cryptography.controller.dto;

import com.rafa.cryptography.entity.Transaction;

import java.util.UUID;

public record TransactionDto(
        UUID id,
        String userDocument,
        String creditCard,
        Long value
) {
    public static TransactionDto fromEntity(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getRawUserDocument(),
                transaction.getRawCreditCardToken(),
                transaction.getTransactionValue()
        );
    }
}
