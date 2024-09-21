package com.OBS.OBS.services;

import java.util.List;

import com.OBS.OBS.entites.Transaction;

public interface TransactionServices {
     void transferFunds(String fromAccountNumber, String toAccountNumber, Double amount);

     void withdrawFunds(String accountNumber, Double amount);

	 void creditFunds(String accountNumber, Double amount);
    
    List<Transaction> getTransactions(String accountNumber);
}
