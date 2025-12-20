package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAccountRepository extends JpaRepository<AccountEntity, UUID> {
}
