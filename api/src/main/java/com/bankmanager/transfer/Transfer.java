package com.bankmanager.transfer;

import com.bankmanager.account.AccountId;

public interface Transfer {

    AccountId getFromAccountId();

    AccountId getToAccountId();

    double getAmount();

    TransferType getType();

    boolean getSuccess();

    double getTotalAmountToTransfer();

}
