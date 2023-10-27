package br.com.m4y50n.bankapi.service;

import br.com.m4y50n.bankapi.model.Transaction;
import br.com.m4y50n.bankapi.repository.TransactionRepository;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transData) {
        final Transaction createTransaction = new Transaction(transData.getPayee(), transData.getAmount(),
                transData.getPayeer());

        return transactionRepository.save(createTransaction);
    }
}
