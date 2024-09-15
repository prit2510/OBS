package com.OBS.OBS.repositories;

import org.springframework.stereotype.Repository;
import com.OBS.OBS.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {

   
}
