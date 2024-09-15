package com.OBS.OBS.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.OBS.OBS.entites.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

     Optional<Account> findByaccountNumber(String accountNumber);

}
