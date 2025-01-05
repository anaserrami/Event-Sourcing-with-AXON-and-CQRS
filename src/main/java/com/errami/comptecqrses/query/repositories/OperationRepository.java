package com.errami.comptecqrses.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.errami.comptecqrses.query.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}