package com.example.test1.controller;

import com.example.test1.dto.TransictionHistoryDTO;
import com.example.test1.service.implement.TransictionHistoryServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransictionHistoryController {

    @Autowired
    private TransictionHistoryServiceInterface transictionHistoryServiceInterface;

    @PostMapping("/luu-giao-dich")
    public ResponseEntity<String> saveTransaction(@Valid @RequestBody TransictionHistoryDTO transactionDTO) throws Exception {
        transictionHistoryServiceInterface.saveTransaction(
                transactionDTO.getTransactionId(),
                transactionDTO.getAccount(),
                transactionDTO.getInDebt(),
                transactionDTO.getHave(),
                transactionDTO.getTime()
        );

        return new ResponseEntity<>("Transaction saved successfully", HttpStatus.OK);
    }
}
