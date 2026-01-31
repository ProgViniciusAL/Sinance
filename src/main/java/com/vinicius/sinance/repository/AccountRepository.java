package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.AccountEntity;
import com.vinicius.sinance.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    List<AccountEntity> findAccountEntitiesByUser(UserEntity user);
}
