package com.unt.account.Service;

import com.unt.account.Model.Account;

import java.util.List;

public interface AccountsService{
    Account saveAccounts(Account account);
    List<Account> getAllAccounts();
    Account getAccountByAccountNumber(Long accountNumber);
    Account updateAccount(Account account, Long accountNumber);
    void deleteAccount(Long accountNumber);
}
