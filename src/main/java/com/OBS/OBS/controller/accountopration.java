package com.OBS.OBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.OBS.OBS.forms.TransferForm;
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
    public String accountcreation(Model model) {
        model.addAttribute("transferForm", new TransferForm());
        return "accountoprations/transfer";
    }
    

    @RequestMapping("/do-transfer")
    public String doCreate(@Valid @ModelAttribute TransferForm transferForm,BindingResult bindingResult,HttpSession session) {
        System.out.println(transferForm);
        if (bindingResult.hasErrors()) {
            return "accountcreation";  // return back to form if validation fails
        }
        transactionServices.transferFunds(transferForm.getFromAccountNumber(), transferForm.getToAccountNumber(), transferForm.getTransactionAmount());
       

        // message = "Transection Successful"
        // add the message:
        message msg = message.builder().content("Transection Successful").type(messageType.green).build();

        session.setAttribute("message", msg);
        return "accountoprations/transfer";
    }
}

        

