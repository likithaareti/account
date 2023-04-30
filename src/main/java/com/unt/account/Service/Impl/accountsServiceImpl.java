package com.unt.account.Service.Impl;

import com.unt.account.Exceptions.AccountException;
import com.unt.account.Model.Account;
import com.unt.account.Repositories.AccountRepository;
import com.unt.account.Service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountsServiceImpl implements AccountsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account saveAccounts(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

   @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        return accountRepository.findById(accountNumber).orElseThrow(
                () -> new AccountException("Account","accountNumber",accountNumber));
    }

    @Override
    public Account updateAccount(Account account, Long accountNumber) {

        Account existingAccount = accountRepository.findById(accountNumber).orElseThrow(
                () -> new AccountException("Employee","Id",accountNumber));
        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setAccountType(account.getAccountType());
        existingAccount.setAccountStatus(account.getAccountStatus());
        existingAccount.setAccountCreationYear(account.getAccountCreationYear());
        accountRepository.save(existingAccount);
        return existingAccount;
    }

    @Override
    public void deleteAccount(Long accountNumber) {
       accountRepository.deleteById(accountNumber);
    }
}
