package com.vinicius.sinance.repository;

import com.vinicius.sinance.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
