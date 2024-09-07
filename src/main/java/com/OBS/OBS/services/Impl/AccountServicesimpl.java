package com.OBS.OBS.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OBS.OBS.entites.Account;
import com.OBS.OBS.repositories.AccountRepo;
import com.OBS.OBS.services.AccountServices;


@Service
public class AccountServicesimpl implements AccountServices {
    @Autowired
    private AccountRepo accountRepo;



    @Override
    public Account createAccount(Account account) {
        return accountRepo.save(account);
        }

    
}
