package com.bankmanager.transfer;

public class FailedTransactionException extends Exception {
    public FailedTransactionException() {
        super("Failed Transaction!");
    }
}
