package com.bankmanager.transfer;

import com.bankmanager.account.AccountId;

public class IntraBankTransfer implements Transfer {

    private AccountId fromAccountId;
    private AccountId toAccountId;
    private double amount;

    public IntraBankTransfer(AccountId fromAccountId, AccountId toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public AccountId getFromAccountId() {
        return fromAccountId;
    }

    public AccountId getToAccountId() {
        return toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public double getTotalAmountToTransfer() {
        return getAmount();
    }

    public TransferType getType() {
        return TransferType.INTRA_BANK;
    }

    public boolean getSuccess(){
        return true;
    }

}
