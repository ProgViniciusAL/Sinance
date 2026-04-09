package com.vinicius.sinance.mapper;

import com.vinicius.sinance.dto.account.AccountResponse;
import com.vinicius.sinance.model.AccountEntity;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {

    public static AccountResponse mapToAccountResponse(AccountEntity accountEntity) {
        return new AccountResponse(
                accountEntity.getId(),
                accountEntity.getName(),
                accountEntity.getAccountType()
        );
    }

    public static List<AccountResponse> mapToAccountResponse(List<AccountEntity> accountEntityList) {
        List<AccountResponse> accountResponseList = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntityList) {
            accountResponseList.add(mapToAccountResponse(accountEntity));
        }
        return accountResponseList;
    }

}
