package com.ferafln.finance.controller.dto.auth;

import com.ferafln.finance.RegexPattern;
import com.ferafln.finance.message.I18n;
import com.ferafln.finance.enums.Role;
import com.ferafln.finance.message.Message;
import com.ferafln.finance.model.User;
import com.ferafln.finance.util.LangEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = Message.Constants.FIRSTNAME_REQUIRED)
    private String firstname;

    @NotBlank(message = Message.Constants.LASTNAME_REQUIRED)
    private String lastname;

    @NotBlank(message = Message.Constants.USERNAME_REQUIRED)
    private String username;

    @NotBlank(message = Message.Constants.PASSWORD_REQUIRED)
    @Pattern(regexp = RegexPattern.PASSWORD, message = Message.Constants.INVALID_PASSWORD)
    private String password;

    @NotBlank(message = Message.Constants.EMAIL_REQUIRED)
    private String email;

    @NotNull(message = Message.Constants.LANGUAGE_REQUIRED)
    private LangEnum lang;

    @NotNull(message = Message.Constants.ROLE_REQUIRED)
    private Role role;

    public User mapToUser(PasswordEncoder encoder) {
        return User.builder()
                .email(email)
                .password(encoder.encode(password))
                .firstname(firstname)
                .lastname(lastname)
                .username(username)
                .role(role)
                .lang(lang)
                .enabled(true)
                .build();
    }
}