package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.TransactionDTO;
import com.miApp.AppS.entity.Transaction;
import com.miApp.AppS.exceptions.CustomException;
import com.miApp.AppS.repository.TransactionRepository;
import com.miApp.AppS.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl  implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository= transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public TransactionDTO findAllTransactions() {
        return null;
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new CustomException("Transaction not found with id: " + transactionId));
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        if (transactionRepository.findById(transactionDTO.getIdTransaction()).isPresent()) {
            throw new CustomException("Transaction with this ID already exists");
        }
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        transaction = transactionRepository.save(transaction);
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO updateTransaction(Long transactionId, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new CustomException("Transaction not found with id: " + transactionId));
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(updatedTransaction, TransactionDTO.class);
    }

    @Override
    public boolean deleteTransaction(Long transactionId) {
        if (!transactionRepository.existsById(transactionId)) {
            throw new CustomException("Transaction not found with id: " + transactionId);
        }
        transactionRepository.deleteById(transactionId);
        return true;

    }
}

