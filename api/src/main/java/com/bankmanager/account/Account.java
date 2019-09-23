package com.bankmanager.account;

public interface Account {

    AccountId getAccountId();

    void setAccountId(AccountId accountId);

    String getCustomerId();

    void setCustomerId(String customerId);

    double getBalance();

    void setBalance(double balance);

}
