package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}
