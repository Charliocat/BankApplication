package com.bankmanager.bank;

import com.bankmanager.transfer.TransferJson;

public class BankManager {

    private Bank bank;

    public BankManager(Bank bank) {
        this.bank = bank;
    }

    public void newTransfer(TransferJson transferJson) throws Exception {
        BankOperations operations = new BankOperations(bank.getAccounts());
        operations.newTransfer(transferJson);
    }

}
