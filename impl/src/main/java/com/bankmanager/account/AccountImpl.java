package com.bankmanager.account;

import com.bankmanager.transfer.Transfer;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account, AccountOperations{

    private String customerId;
    private AccountId accountId;
    private double balance;
    private List<Transfer> transfers;

    public AccountImpl(AccountId accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void addTransfer(Transfer transfer) {
        if (transfers == null){
            transfers = new ArrayList<Transfer>();
        }
        transfers.add(transfer);
    }

    public void withdraw(double amount) throws Exception {
        if (balance > 0){
            balance = balance - amount;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }
}
