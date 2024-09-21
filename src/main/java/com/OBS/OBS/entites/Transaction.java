package com.OBS.OBS.entites;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID for sequential order
    private Long transactionId;
    private String transactionType;
    private Double transactionAmount;
    private String transactionDate;
    private String transactionAccountNumber;
    private String remainingAmount;

    @ManyToOne
    @JsonIgnore
    private Account account;

    public Transaction( String transactionType, Double transactionAmount, String transactionDate, String transactionAccountNumber,String remainingAmount,Account account) {
        this.transactionType = transactionType;
        this.transactionAmount=transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionAccountNumber = transactionAccountNumber;
        this.remainingAmount = remainingAmount;
        this.account = account;
    }


   
   }
