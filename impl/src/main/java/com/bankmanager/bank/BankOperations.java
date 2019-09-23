package com.bankmanager.bank;

import com.bankmanager.account.Account;
import com.bankmanager.account.AccountImpl;
import com.bankmanager.transfer.FailedTransactionException;
import com.bankmanager.transfer.Transfer;
import com.bankmanager.transfer.TransferFactory;
import com.bankmanager.transfer.TransferJson;

import java.util.Map;

public class BankOperations {

    private Map<String, Account> accounts;

    public BankOperations(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public void newTransfer(TransferJson transferJson) throws Exception {
        Transfer transfer = TransferFactory.getTransfer(transferJson);
        if (transfer.getSuccess()){
            AccountImpl fromAccount = (AccountImpl) accounts.get(transfer.getFromAccountId().getSepa());
            AccountImpl toAccount = (AccountImpl) accounts.get(transfer.getToAccountId().getSepa());
            double amountToTransfer = transfer.getTotalAmountToTransfer();

            if(fromAccount != null && toAccount != null ){
                fromAccount.withdraw(amountToTransfer);
                fromAccount.addTransfer(transfer);
                toAccount.deposit(amountToTransfer);
                toAccount.addTransfer(transfer);
            } else {
                throw new FailedTransactionException();
            }

        } else {
            throw new FailedTransactionException();
        }
    }

}
