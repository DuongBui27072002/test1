package com.example.test1.service;

import com.example.test1.dto.TransictionHistoryDTO;
import com.example.test1.entity.TransictionHistoryEntity;
import com.example.test1.repository.TransictionHistoryRepository;
import com.example.test1.service.implement.TransictionHistoryServiceInterface;
import com.example.test1.until.AESUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDate;

@Service
public class TransicitionHistoryService implements TransictionHistoryServiceInterface {

    @Autowired
    private TransictionHistoryRepository transactionHistoryRepository;

    @Autowired
    private AESUntil aesUntil;

    private SecretKey secretKey;

    public TransicitionHistoryService() throws Exception {
        // Generate AES Key
        this.secretKey = AESUntil.generateKey();
    }

    @Override
    public void saveTransaction(Integer transactionId, Integer account, Double inDebt, Double have, LocalDate time) throws Exception {
        TransictionHistoryEntity transactionHistory = new TransictionHistoryEntity();
        transactionHistory.setTransactionId(transactionId);
        transactionHistory.setAccount(aesUntil.encrypt(account.toString(), secretKey)); // Encrypt account as String
        transactionHistory.setInDebt(inDebt);
        transactionHistory.setHave(have);
        transactionHistory.setTime(time);

        transactionHistoryRepository.save(transactionHistory);
    }
}
