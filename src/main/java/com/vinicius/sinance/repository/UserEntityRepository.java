package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserDetails> findByEmail(String email);

    UserEntity getUserEntityByEmail(String email);

}
