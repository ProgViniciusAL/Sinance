package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

    List<TransactionEntity> findAllByAccountId(UUID accountId);
    @Query("""
        SELECT COALESCE(SUM(
            CASE
                WHEN t.type = 0 THEN t.amount
                WHEN t.type = 1 THEN -t.amount
            END
        ), 0)
        FROM TransactionEntity t
        WHERE t.account.id = :accountId
    """)
    BigDecimal findBalanceByAccountId(UUID accountId);

}
