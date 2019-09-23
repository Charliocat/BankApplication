package com.bankmanager.repository;

import com.bankmanager.account.Account;
import com.bankmanager.account.AccountImpl;
import com.bankmanager.account.AccountId;
import com.bankmanager.bank.Bank;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccountsRepository {

    private static final Map<String, Account> accounts = new HashMap<String, Account>();

    @PostConstruct
    public void initData(){

        Account accountImpl = new AccountImpl(new AccountId("BBVA", "1234567890"), 100.00);
        accounts.put(accountImpl.getAccountId().getBankSwift() + accountImpl.getAccountId().getAccountId(), accountImpl);

        Account accountImpl2 = new AccountImpl(new AccountId("BBVA", "1233211233"), 5001.00);
        accounts.put(accountImpl2.getAccountId().getBankSwift() + accountImpl2.getAccountId().getAccountId(), accountImpl2);

        Account accountImpl3 = new AccountImpl(new AccountId("CAXA", "7788994455"), 980.25);
        accounts.put(accountImpl3.getAccountId().getBankSwift() + accountImpl3.getAccountId().getAccountId(), accountImpl3);
    }

    public Account findAccount(AccountId accountId) {
        return accounts.get(accountId.getBankSwift() + accountId.getAccountId());
    }

    public Map<String, Account> findAccounts(Bank bank) {
        Map<String, Account> result = new HashMap<>();
        for (Map.Entry<String, Account> account : accounts.entrySet()){
            if (account.getKey().contains(bank.getSwift())){
                result.put(account.getKey(), account.getValue());
            }
        }
        return result;
    }
    public Map<String, Account> getAccounts(){
        return accounts;
    }

}
