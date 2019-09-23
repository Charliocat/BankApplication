package com.bankmanager.transfer;

import com.bankmanager.account.AccountId;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;

public class TransferJson {

    @JsonProperty("from_account")
    private AccountId fromAccountId;

    @JsonProperty("to_account")
    private AccountId toAccountId;

    @Digits(integer = 10, fraction=2)
    private double amount;

    public TransferJson(){}

    public AccountId getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(AccountId fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public AccountId getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(AccountId toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
