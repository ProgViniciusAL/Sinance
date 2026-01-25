package com.vinicius.sinance.model;

import com.vinicius.sinance.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TransactionEntity> transaction = new ArrayList<>();

    private Boolean isActive;

    public AccountEntity() {
        this.setIsActive(true);
    }

    public Boolean isAccountActive() {
        return this.isActive;
    }
}
