package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.TransactionDTO;
import com.miApp.AppS.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl  implements TransactionService {

    private final TransactionService transactionService;
    public TransactionServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public TransactionServiceImpl() {
        this.transactionService = null; // This is not a good practice, but included to match the constructor signature.
    }

    @Override
    public TransactionDTO findAllTransactions() {
        return null;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public TransactionDTO updateTransaction(Long transactionId, TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteTransaction(Long transactionId) {

    }
}
