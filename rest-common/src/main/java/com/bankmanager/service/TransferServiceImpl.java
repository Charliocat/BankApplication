package com.bankmanager.service;

import com.bankmanager.bank.Bank;
import com.bankmanager.bank.BankManager;
import com.bankmanager.repository.AccountsRepository;
import com.bankmanager.repository.BankRepository;
import com.bankmanager.repository.CustomersRepository;
import com.bankmanager.transfer.TransferJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public ResponseEntity<String> newTransfer(TransferJson transferJson) {
        Bank bank =  bankRepository.findBank(transferJson.getFromAccountId().getBankSwift());
        bank.setAccounts(accountsRepository.getAccounts());
        bank.setCustomers(customersRepository.getCustomers());
        BankManager bankManager = new BankManager(bank);

        try {
            bankManager.newTransfer(transferJson);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Transfer Done", HttpStatus.OK);
    }

}
