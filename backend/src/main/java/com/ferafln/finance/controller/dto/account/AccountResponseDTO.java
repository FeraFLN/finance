package com.ferafln.finance.controller.dto.account;

import com.ferafln.finance.model.Account;
import com.ferafln.finance.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Builder
public class AccountResponseDTO {
    private String name;
    private List<String> users;

    public static AccountResponseDTO build(Account account){
        List<String> us = null;
        if(Objects.nonNull(account.getUsers())){
            us = account.getUsers().stream().map(User::getUsername).toList();
        }
        return AccountResponseDTO.builder().name(account.getName()).users(us).build();
    }

}
