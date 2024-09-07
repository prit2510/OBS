package com.OBS.OBS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OBS.OBS.entites.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
