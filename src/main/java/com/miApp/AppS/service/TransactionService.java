package com.miApp.AppS.service;

import com.miApp.AppS.dto.TransactionDTO;

public interface TransactionService {
    TransactionDTO findAllTransactions();

    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransactionById(Long transactionId);
    TransactionDTO updateTransaction(Long transactionId, TransactionDTO transactionDTO);
    void deleteTransaction(Long transactionId);

}
