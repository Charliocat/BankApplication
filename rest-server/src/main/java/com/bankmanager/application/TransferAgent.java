package com.bankmanager.application;

import com.bankmanager.transfer.TransferJson;
import com.bankmanager.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfer-agent")
public class TransferAgent {

    @Autowired
    private TransferService service;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> newTransfer(@RequestBody TransferJson transfer){
        return service.newTransfer(transfer);
    }
}
