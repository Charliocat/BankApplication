package com.bankmanager.transfer;

import com.bankmanager.account.AccountId;

import java.util.Random;

public class InterBankTransfer implements Transfer {

    private static final double LIMIT = 1000.00;
    private static final double COMISSION = 5.00;

    private AccountId fromAccountId;
    private AccountId toAccountId;
    private double amount;

    public InterBankTransfer(AccountId fromAccountId, AccountId toAccountId, double amount) throws Exception {

        if(amount > LIMIT)
            throw new TransferLimitException();

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
        return amount + COMISSION;
    }

    public TransferType getType() {
        return TransferType.INTER_BANK;
    }

    public boolean getSuccess(){
        Random random = new Random();
        int chance = random.nextInt(100-1) + 1;
        if (chance > 30)
            return true;

        return false;
    }

}
