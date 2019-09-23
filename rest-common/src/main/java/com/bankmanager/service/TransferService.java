package com.bankmanager.service;

import com.bankmanager.transfer.TransferJson;
import org.springframework.http.ResponseEntity;


public interface TransferService {
    ResponseEntity<String> newTransfer(TransferJson transfer);
}
