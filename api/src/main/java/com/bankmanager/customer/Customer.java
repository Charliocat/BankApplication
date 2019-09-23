package com.bankmanager.customer;

import com.bankmanager.account.Account;

public interface Customer {

    String getName();

    String getCustomerId();

    void addAccount(Account account);

}
