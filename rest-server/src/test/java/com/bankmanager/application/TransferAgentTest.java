package com.bankmanager.application;


import com.bankmanager.account.AccountId;
import com.bankmanager.transfer.TransferJson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = BankApplication.class)
class TransferAgentTest {

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() {

        TransferJson transferJson = new TransferJson();
        transferJson.setFromAccountId(new AccountId("BBVA", "123"));
        transferJson.setToAccountId(new AccountId("BBVA", "456"));
        transferJson.setAmount(10.00);

        HttpEntity<TransferJson> entity = new HttpEntity<>(transferJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/transfer-agent/transfer"),
                HttpMethod.POST, entity, String.class);

        assertTrue(response.getBody().equals("Failed Transaction!"));
    }

    @Test
    public void testSuccessfulTransaction() {

        TransferJson transferJson = new TransferJson();
        transferJson.setFromAccountId(new AccountId("BBVA", "1234567890"));
        transferJson.setToAccountId(new AccountId("BBVA", "1233211233"));
        transferJson.setAmount(10.00);

        HttpEntity<TransferJson> entity = new HttpEntity<>(transferJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/transfer-agent/transfer"),
                HttpMethod.POST, entity, String.class);

        assertTrue(response.getBody().equals("Transaction Done"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + 8080 + uri;
    }

}