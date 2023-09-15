package com.ferafln.finance.controller.dto.account;

import com.ferafln.finance.message.Message;
import com.ferafln.finance.model.Account;
import com.ferafln.finance.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegisterRequestDTO {
    @NotBlank(message = Message.Constants.ACCOUNT_REQUIRED)
    public String name;
    public List<Integer> users;

    public Account parseToAccount(){
        List<User> us = null;
        if(Objects.nonNull(this.users)){
            us = this.users.stream().map((user)-> User.builder().id(user).build()).toList();
        }
        return Account.builder()
                .users(us)
                .name(this.name)
                .build();
    }
}
