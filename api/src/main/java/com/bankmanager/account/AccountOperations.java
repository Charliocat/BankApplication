package com.bankmanager.account;

import com.bankmanager.transfer.Transfer;

import java.util.List;

public interface AccountOperations {

    void withdraw(double amount) throws Exception;

    void deposit(double amount);

    void addTransfer(Transfer transfer);

    List<Transfer> getTransfers();

}
