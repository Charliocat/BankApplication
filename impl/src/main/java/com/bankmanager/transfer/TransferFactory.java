package com.bankmanager.transfer;

public class TransferFactory {

    public static Transfer getTransfer(TransferJson transferJson) throws Exception{
        if(transferJson.getFromAccountId().getBankSwift().equals(transferJson.getToAccountId().getBankSwift())){
            return new IntraBankTransfer(transferJson.getFromAccountId(), transferJson.getToAccountId(), transferJson.getAmount());
        } else {
            return new InterBankTransfer(transferJson.getFromAccountId(), transferJson.getToAccountId(), transferJson.getAmount());
        }

    }

}
