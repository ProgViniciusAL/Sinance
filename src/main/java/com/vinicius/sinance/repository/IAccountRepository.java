package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IAccountRepository extends JpaRepository<AccountEntity, UUID> {
    Set<AccountEntity> findAccountEntitiesByUser(UserEntity user);
}
