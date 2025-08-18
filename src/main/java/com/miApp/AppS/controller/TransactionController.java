package com.miApp.AppS.controller;


import com.miApp.AppS.dto.TransactionDTO;
import com.miApp.AppS.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> getTransactionById(Long transactionId) {
        TransactionDTO transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }
    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> createTransaction(@Validated @RequestBody TransactionDTO transactionDTO) {
        transactionService.createTransaction(transactionDTO);
        return ResponseEntity.ok(transactionDTO);
    }
}
