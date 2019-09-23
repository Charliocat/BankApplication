package com.bankmanager.account;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(){
        super("Not enough money to transfer");
    }

}
