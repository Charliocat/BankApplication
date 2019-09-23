package com.bankmanager.customer;

import com.bankmanager.account.Account;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

    private String name;
    private String customerId;
    private List<Account> accounts;

    public CustomerImpl(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public void addAccount(Account account) {
        if (accounts == null)
            accounts = new ArrayList<>();
        accounts.add(account);
    }

}
