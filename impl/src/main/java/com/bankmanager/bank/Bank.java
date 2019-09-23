package com.bankmanager.bank;

import com.bankmanager.account.Account;
import com.bankmanager.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();

    private String name;
    private String swift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public void setAccounts(Map<String, Account> accounts){
        this.accounts.putAll(accounts);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers.putAll(customers);
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

}
