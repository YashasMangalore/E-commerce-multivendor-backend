package com.ecom.service;

import com.ecom.model.Order;
import com.ecom.model.Seller;
import com.ecom.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}
