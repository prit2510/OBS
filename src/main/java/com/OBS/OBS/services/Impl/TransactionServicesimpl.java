package com.OBS.OBS.services.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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
            
                String remainingFromAmount = fromAccount.getAccountBalance().toString();
                String remainingToAmount = toAccount.getAccountBalance().toString();
                // Record the transactions
                transactionRepo.save(new Transaction("Transfer", amount,currentDate.toString(),toAccountNumber,remainingToAmount,toAccount));
                Double newAmount = amount * 2;
                amount -= newAmount;
                transactionRepo.save(new Transaction("Transfer", amount,currentDate.toString(),fromAccountNumber,remainingFromAmount,fromAccount));
            } else {
                throw new RuntimeException("Insufficient funds or account not found");
            }
    }



    @Override
    public void withdrawFunds(String accountNumber, Double amount) {
        Account account = accountRepo.findByaccountNumber(accountNumber)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with AC number : " + accountNumber));
        
        LocalDate currentDate = LocalDate.now();
        if(account != null && account.getAccountBalance() >= amount){
            account.setAccountBalance(account.getAccountBalance() - amount);
            accountRepo.save(account);
            String remainingAmount = account.getAccountBalance().toString();
            transactionRepo.save(new Transaction("Withdraw", amount,currentDate.toString(),accountNumber,remainingAmount,account));
        }

    }



    @Override
    public void creditFunds(String accountNumber, Double amount) {
        Account account = accountRepo.findByaccountNumber(accountNumber)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with AC number : " + accountNumber));
        
        LocalDate currentDate = LocalDate.now();
        if(account != null){
            account.setAccountBalance(account.getAccountBalance() + amount);
            accountRepo.save(account);
            String remainingAmount = account.getAccountBalance().toString();
            transactionRepo.save(new Transaction("Credit", amount,currentDate.toString(),accountNumber,remainingAmount,account));
        }    
    }



    @Override
    public List<Transaction> getTransactions(String accountNumber) {
        return transactionRepo.findBytransactionAccountNumber(accountNumber);
    }
}
