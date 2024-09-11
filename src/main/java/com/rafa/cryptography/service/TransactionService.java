package com.rafa.cryptography.service;

import com.rafa.cryptography.controller.dto.TransactionCreationDto;
import com.rafa.cryptography.controller.dto.TransactionDto;
import com.rafa.cryptography.entity.Transaction;
import com.rafa.cryptography.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.repository = transactionRepository;
    }

    public void create(TransactionCreationDto transaction) {
        var entity = new Transaction();
        entity.setRawUserDocument(transaction.userDocument());
        entity.setRawCreditCardToken(transaction.creditCardToken());
        entity.setTransactionValue(transaction.value());

        repository.save(entity);
    }

    public Page<TransactionDto> listAll(int page, int pageSize) {
        var content = repository.findAll(PageRequest.of(page, pageSize));

        return content.map(TransactionDto::fromEntity);
    }
}
