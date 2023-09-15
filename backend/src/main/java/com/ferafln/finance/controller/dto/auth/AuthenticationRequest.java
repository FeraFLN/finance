package com.ferafln.finance.controller.dto.auth;

import com.ferafln.finance.message.I18n;
import com.ferafln.finance.message.Message;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotBlank(message = Message.Constants.FORBIDDEN)
    private String username;

    @NotBlank(message = Message.Constants.PASSWORD_REQUIRED)
    private String password;

}
