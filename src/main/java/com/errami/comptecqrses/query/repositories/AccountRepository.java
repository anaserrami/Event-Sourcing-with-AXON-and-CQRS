package com.errami.comptecqrses.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.errami.comptecqrses.query.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}