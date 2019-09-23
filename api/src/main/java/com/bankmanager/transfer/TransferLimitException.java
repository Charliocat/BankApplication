package com.bankmanager.transfer;

public class TransferLimitException extends Exception {

    public TransferLimitException(){
        super("Limit above 1000€");
    }

}
