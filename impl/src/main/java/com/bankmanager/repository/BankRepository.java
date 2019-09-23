package com.bankmanager.repository;

import com.bankmanager.bank.Bank;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    private static final Map<String, Bank> banks = new HashMap<String, Bank>();

    @PostConstruct
    public void initData(){

        Bank caixa = new Bank();
        caixa.setName("La Caixa");
        caixa.setSwift("CAXA");

        banks.put(caixa.getSwift(), caixa);

        Bank bbva = new Bank();
        bbva.setName("BBVA");
        bbva.setSwift("BBVA");

        banks.put(bbva.getSwift(), bbva);
    }

    public Bank findBank(String swift) {
        return banks.get(swift);
    }
}
