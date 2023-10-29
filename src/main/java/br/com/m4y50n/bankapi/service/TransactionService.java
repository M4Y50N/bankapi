package br.com.m4y50n.bankapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m4y50n.bankapi.model.Transaction;
import br.com.m4y50n.bankapi.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transData) {
        final Transaction createTransaction = new Transaction(transData.getPayer(), transData.getAmount(),
                transData.getPayee());

        return transactionRepository.save(createTransaction);
    }

    public List<Transaction> readTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction retriveTransaction(Long accountId) throws Exception {
        return transactionRepository.findById(accountId)
                .orElseThrow(() -> new Exception("Error: Account for Transactions not found"));
    }
}
