package com.OBS.OBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OBS.OBS.entites.Account;
import com.OBS.OBS.forms.accountform;
import com.OBS.OBS.helper.message;
import com.OBS.OBS.helper.messageType;
import com.OBS.OBS.services.AccountServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class accountcontroller {
    
    @Autowired
    private AccountServices accountservice;

    @GetMapping("/")
    public String index() {
        return "redirect:/account";
    }

    @RequestMapping("/account")
    public String account() {
        return "home";
    }
   
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/createaccount")
    public String accountcreation(Model model) {
        model.addAttribute("accountform", new accountform());
        return "accountcreation";
    }
    

    @RequestMapping("/do-create")
    public String doCreate(@Valid @ModelAttribute accountform accountform,BindingResult bindingResult,HttpSession session) {
        System.out.println(accountform);
        if (bindingResult.hasErrors()) {
            return "accountcreation";  // return back to form if validation fails
        }
        Account account = Account.builder()
                .accountNumber(accountform.getAccountNumber())
                .accountHolderName(accountform.getAccountHolderName())
                .accountPin(accountform.getAccountPin())
                .accountBalance(accountform.getAccountBalance())
                .build();
                accountservice.createAccount(account);

                // message = "Registration Successful"

        // add the message:

        message msg = message.builder().content("Registration Successful").type(messageType.green).build();

        session.setAttribute("message", msg);
        return "accountcreation";
    }
}
