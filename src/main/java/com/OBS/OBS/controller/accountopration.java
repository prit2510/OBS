package com.OBS.OBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OBS.OBS.forms.CreditForm;
import com.OBS.OBS.forms.TransferForm;
import com.OBS.OBS.forms.withdrowForm;
import com.OBS.OBS.helper.Helper;
import com.OBS.OBS.helper.message;
import com.OBS.OBS.helper.messageType;
import com.OBS.OBS.services.TransactionServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/accountnumber")
public class accountopration {

     @Autowired
     private TransactionServices transactionServices;

     

      @RequestMapping(path="/dashbord")
      public String requestMethodName() {
          return "accountoprations/dashbord";
      }
    @RequestMapping("/transection")
    public String balance() {
        return "accountoprations/transection";
    }


    @RequestMapping("/transfer")
    public String transfer(Model model, Authentication authentication) {
        model.addAttribute("transferForm", new TransferForm());
    
        // Get the current account number of the logged-in user
        String currentAccount = Helper.getaccountNumberOfLoggedInUser(authentication);
        
        // Add the current account number to the model
        model.addAttribute("currentAccount", currentAccount);
        
        return "accountoprations/transfer";
    }
    

    @RequestMapping("/do-transfer")
    public String dotransfer(@Valid @ModelAttribute TransferForm transferForm,BindingResult bindingResult,Authentication authentication,HttpSession session) {
        System.out.println(transferForm);
        String currentaccount=Helper.getaccountNumberOfLoggedInUser(authentication);
        if (bindingResult.hasErrors()) {
            return "accountoprations/transfer";  // return back to form if validation fails
        }
        transferForm.setFromAccountNumber(currentaccount);
        transactionServices.transferFunds(transferForm.getFromAccountNumber(), transferForm.getToAccountNumber(), transferForm.getTransactionAmount());
       

        // message = "Transection Successful"
        // add the message:
        message msg = message.builder().content("Transection Successful").type(messageType.green).build();

        session.setAttribute("message", msg); 
          
       
        return "accountoprations/transfer";
    }

    @RequestMapping("/withdrow")
    public String withdrow(Model model,Authentication authentication) {
        String currentaccount=Helper.getaccountNumberOfLoggedInUser(authentication);
        model.addAttribute("withdrowForm", new withdrowForm());
        model.addAttribute("currentAccount", currentaccount);
        return "accountoprations/withdrow";
    }
    @RequestMapping("/do-withdrow")
    public String dowithdrow(@Valid @ModelAttribute withdrowForm withdrowForm,BindingResult bindingResult,Authentication authentication,HttpSession session) {
        System.out.println(withdrowForm);
        if (bindingResult.hasErrors()) {
            return "accountoprations/withdrow";  // return back to form if validation fails
        }
        String currentaccount=Helper.getaccountNumberOfLoggedInUser(authentication);
        withdrowForm.setAccountNumber(currentaccount);
        transactionServices.withdrawFunds(withdrowForm.getAccountNumber(), withdrowForm.getTransactionAmount());
        // message = "Transection Successful"
        // add the message:
        message msg = message.builder().content("withdrow Successful").type(messageType.green).build();

        session.setAttribute("message", msg);
        return "accountoprations/withdrow";
    }

    @RequestMapping("/credit")
    public String credit(Model model,Authentication authentication) {
        String currentaccount=Helper.getaccountNumberOfLoggedInUser(authentication);
        model.addAttribute("creditForm", new CreditForm());
        model.addAttribute("currentAccount", currentaccount);
        return "accountoprations/credit";
    }
    @RequestMapping("/do-credit")
    public String doCredit(@Valid @ModelAttribute CreditForm creditForm,BindingResult bindingResult,Authentication authentication,HttpSession session) {
        String currentaccount=Helper.getaccountNumberOfLoggedInUser(authentication);
        System.out.println(creditForm);
        if (bindingResult.hasErrors()) {
            return "accountoprations/credit";  // return back to form if validation fails
        }
        creditForm.setAccountNumber(currentaccount);
        transactionServices.creditFunds(creditForm.getAccountNumber(), creditForm.getTransactionAmount());
        // message = "Transection Successful"
        // add the message:
        message msg = message.builder().content("Amount Credited Successful").type(messageType.green).build();

        session.setAttribute("message", msg);
        return "accountoprations/credit";
    }

}

        

