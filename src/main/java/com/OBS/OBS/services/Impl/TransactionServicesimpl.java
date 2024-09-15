package com.OBS.OBS.services.Impl;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import com.OBS.OBS.entites.Account;
import com.OBS.OBS.entites.Transaction;
import com.OBS.OBS.repositories.AccountRepo;
import com.OBS.OBS.repositories.TransactionRepo;
import com.OBS.OBS.services.TransactionServices;

@Service
public class TransactionServicesimpl implements TransactionServices {
    
    @Autowired
    private AccountRepo accountRepo;
    
    @Autowired
    private TransactionRepo transactionRepo;

    

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, Double amount) {
        
        String transectionId = UUID.randomUUID().toString();

        Account fromAccount = accountRepo.findByaccountNumber(fromAccountNumber)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with AC number : " + fromAccountNumber));
        
            Account toAccount = accountRepo.findByaccountNumber(toAccountNumber)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with AC number : " + toAccountNumber));  
            
            LocalDate currentDate = LocalDate.now();

            if (fromAccount != null && toAccount != null && fromAccount.getAccountBalance() >= amount) {
                fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
                toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
    
                accountRepo.save(fromAccount);
                accountRepo.save(toAccount);
    
                // Record the transactions
                transactionRepo.save(new Transaction(transectionId,"Transfer", amount,currentDate.toString(),fromAccountNumber,fromAccount));
                transactionRepo.save(new Transaction(transectionId,"Transfer", amount,currentDate.toString(),toAccountNumber,toAccount));
            } else {
                throw new RuntimeException("Insufficient funds or account not found");
            }
    }
}
