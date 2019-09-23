package com.bankmanager.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountId {

    @JsonProperty("swift")
    private String bankSwift;

    @JsonProperty("account_id")
    private String accountId;

    public AccountId(){}

    public AccountId(String bankSwift, String accountId) {
        this.bankSwift = bankSwift;
        this.accountId = accountId;
    }

    public String getBankSwift() {
        return bankSwift;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getSepa(){
        return bankSwift + accountId;
    }

}
