package com.rafa.cryptography.controller;

import com.rafa.cryptography.controller.dto.TransactionCreationDto;
import com.rafa.cryptography.controller.dto.TransactionDto;
import com.rafa.cryptography.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TransactionCreationDto transactionCreationDto) {
        service.create(transactionCreationDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionDto>> listAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        var data = service.listAll(page, pageSize);

        return ResponseEntity.ok(data);
    }
}
