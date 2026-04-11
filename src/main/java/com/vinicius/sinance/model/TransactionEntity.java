package com.vinicius.sinance.model;

import com.vinicius.sinance.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String description;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private TransactionType type;

    @NotNull
    @Timestamp
    private LocalDateTime createdAt;
}
