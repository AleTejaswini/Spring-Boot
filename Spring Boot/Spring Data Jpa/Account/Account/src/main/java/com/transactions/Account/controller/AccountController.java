package com.transactions.Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.Account.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountservice;

//    @GetMapping("/transfer")
//    public String transfer(
//            @RequestParam int from,
//            @RequestParam int to,
//            @RequestParam int amt) {
//    	accountservice.transfer(from, to, amt);
//        return "Done";
//    }
    
    @PostMapping("/transfer")
    public String transfer(@RequestParam int fromid,
            @RequestParam int toid,
            @RequestParam int amt) {
    	accountservice.transfer(fromid, toid, amt);
      return "Done";	
    }
}
