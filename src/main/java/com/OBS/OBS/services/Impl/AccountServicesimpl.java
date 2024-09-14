package com.OBS.OBS.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.OBS.OBS.entites.Account;
import com.OBS.OBS.repositories.AccountRepo;
import com.OBS.OBS.services.AccountServices;


@Service
public class AccountServicesimpl implements AccountServices {
    @Autowired
    private AccountRepo accountRepo;

     @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Account createAccount(Account account) {
        account.setAccountPin(passwordEncoder.encode(account.getAccountPin()));
        return accountRepo.save(account);
        }

    
}
