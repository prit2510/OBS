package com.OBS.OBS.services;

import com.OBS.OBS.entites.Transaction;

public interface TransactionServices {
    public void transferFunds(String fromAccountNumber, String toAccountNumber, Double amount);

    public void withdrawFunds(String accountNumber, Double amount);
    
}
