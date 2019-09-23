package com.bankmanager.bank;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bankmanager.account.Account;
import com.bankmanager.account.AccountId;
import com.bankmanager.account.AccountImpl;
import com.bankmanager.transfer.FailedTransactionException;
import com.bankmanager.transfer.TransferJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class BankOperationsTest {

    private BankOperations operations;
    private Map<String, Account> accounts = new HashMap<>();

    @BeforeEach
    public void setUp(){
        Account account = new AccountImpl(new AccountId("BBVA", "123"), 100.00);
        accounts.put(account.getAccountId().getSepa(), account);

        Account account2 = new AccountImpl(new AccountId("BBVA", "456"), 50.00);
        accounts.put(account2.getAccountId().getSepa(), account2);

        Account account3 = new AccountImpl(new AccountId("CAXA", "789"), 1000.00);
        accounts.put(account3.getAccountId().getSepa(), account3);

        operations = new BankOperations(accounts);
    }

    @Test
    void successfulTransfer() throws Exception{
        TransferJson transferJson = new TransferJson();
        transferJson.setFromAccountId(accounts.get("BBVA123").getAccountId());
        transferJson.setToAccountId(accounts.get("BBVA456").getAccountId());
        transferJson.setAmount(75.00);

        operations.newTransfer(transferJson);

        Account accountFrom = accounts.get("BBVA123");
        assertThat(accountFrom.getBalance(), equalTo(25.00));

        Account accountTo = accounts.get("BBVA456");
        assertThat(accountTo.getBalance(), equalTo(125.00));
    }

    @Test
    void unsuccessfulTransfer() throws Exception{
        TransferJson transferJson = new TransferJson();
        transferJson.setFromAccountId(accounts.get("BBVA123").getAccountId());
        Account account = new AccountImpl(new AccountId("CAXA", "888"), 1000.00);
        transferJson.setToAccountId(account.getAccountId());
        transferJson.setAmount(75.00);
        assertThrows(FailedTransactionException.class, () -> operations.newTransfer(transferJson));
    }

}