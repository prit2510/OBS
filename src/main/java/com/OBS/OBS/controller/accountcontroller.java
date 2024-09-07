package com.OBS.OBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OBS.OBS.entites.Account;
import com.OBS.OBS.forms.accountform;
import com.OBS.OBS.services.AccountServices;



@Controller
public class accountcontroller {
    
    @Autowired
    private AccountServices accountservice;

    @RequestMapping("/account")
    public String account() {
        return "home";
    }

    @RequestMapping("/createaccount")
    public String accountcreation(Model model) {
        model.addAttribute("accountform", new accountform());
        return "accountcreation";
    }

    @RequestMapping("/do-create")
    public String doCreate(@ModelAttribute accountform accountform) {
        System.out.println(accountform);
        Account account = Account.builder()
                .accountNumber(accountform.getAccountNumber())
                .accountHolderName(accountform.getAccountHolderName())
                .accountPin(accountform.getAccountPin())
                .accountBalance(accountform.getAccountBalance())
                .build();
                accountservice.createAccount(account);
        return "accountcreation";
    }
}
