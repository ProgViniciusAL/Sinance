package com.vinicius.sinance.model.dto;

import com.vinicius.sinance.model.UserEntity;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String name;
}
