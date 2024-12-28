package com.ecom.controller;

import com.ecom.exception.SellerException;
import com.ecom.model.Order;
import com.ecom.model.Seller;
import com.ecom.model.Transaction;
import com.ecom.service.SellerService;
import com.ecom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final SellerService sellerService;

    @Autowired
    public TransactionController(TransactionService transactionService, SellerService sellerService) {
        this.transactionService = transactionService;
        this.sellerService = sellerService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Order order) {
        Transaction transaction = transactionService.createTransaction(order);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/seller")
    public ResponseEntity<List<Transaction>> getTransactionBySeller(
            @RequestHeader("Authorization") String jwt) throws SellerException {
        Seller seller=sellerService.getSellerProfile(jwt);

        List<Transaction> transactions = transactionService.getTransactionBySeller(seller);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
}
