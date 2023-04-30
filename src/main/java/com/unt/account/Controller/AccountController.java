package com.unt.account.Controller;

import com.unt.account.Model.Account;
import com.unt.account.Service.AccountsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Data
@RestController
@RequestMapping("/acc")
public class AccountController {
    @Autowired
    private AccountsService accountsService;

    @PostMapping("/add")
    public ResponseEntity<Account> saveAccount(@RequestBody Account student){
        return new ResponseEntity<Account>(accountsService.saveAccounts(student), HttpStatus.CREATED);
    }

    //build GET account REST API
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts=accountsService.getAllAccounts();
        Collections.sort(accounts);
        return ResponseEntity.ok(accounts);
    }

    //build Get Account by id REST API
    @GetMapping("{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable("accountNumber") long accountNumber){
        return new ResponseEntity<Account>(accountsService.getAccountByAccountNumber(accountNumber), HttpStatus.OK);
       // return accountsService.getAccountByAccountNumber(accountNumber);
    }
    //build update account by id REST API
    @PutMapping("{accountNumber}")
    public ResponseEntity<Account> updateStudent(@PathVariable("accountNumber") long accountNumber, @RequestBody Account account){
        return new ResponseEntity<Account>(accountsService.updateAccount(account,accountNumber), HttpStatus.OK);

    }

    //Build Delete account REST API
    @DeleteMapping("{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable("accountNumber") long accountNumber){

        accountsService.deleteAccount(accountNumber);
        return new ResponseEntity<>("Account Deleted Successfully!", HttpStatus.OK);
    }
}
