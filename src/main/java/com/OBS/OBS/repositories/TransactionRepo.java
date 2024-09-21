package com.OBS.OBS.repositories;

import org.springframework.stereotype.Repository;
import com.OBS.OBS.entites.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    List<Transaction> findBytransactionAccountNumber(String accountNumber);
}
