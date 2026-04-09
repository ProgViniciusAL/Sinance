package com.vinicius.sinance.model;

import com.vinicius.sinance.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public AccountEntity() {
    }
}
