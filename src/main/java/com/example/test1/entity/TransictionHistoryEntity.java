package com.example.test1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transiction_history")
public class TransictionHistoryEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TransactionID")
    private Integer transactionId;

    @Column(name = "Account")
    private String account;

    @Column(name = "InDebt")
    private Double inDebt;

    @Column(name = "Have")
    private Double have;

    @Column(name = "Time")
    private LocalDate time;


}
