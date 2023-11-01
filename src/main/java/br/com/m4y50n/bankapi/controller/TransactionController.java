package br.com.m4y50n.bankapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.m4y50n.bankapi.model.Transaction;
import br.com.m4y50n.bankapi.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody final Transaction transData) {
        final Transaction createdTransaction = transactionService.createTransaction(transData);

        return new ResponseEntity<Transaction>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> readTransactions() {
        final List<Transaction> allTransactions = transactionService.readTransactions();

        return new ResponseEntity<List<Transaction>>(allTransactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> retriveTransaction(@PathVariable String id) throws Exception {
        final Transaction transaction = transactionService.retriveTransaction(Long.parseLong(id));

        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

}
