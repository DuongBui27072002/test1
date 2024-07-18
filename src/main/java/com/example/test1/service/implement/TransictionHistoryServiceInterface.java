package com.example.test1.service.implement;

import java.time.LocalDate;

public interface TransictionHistoryServiceInterface {
   void saveTransaction(Integer transactionId, Integer account, Double inDebt, Double have, LocalDate time) throws Exception;
}
