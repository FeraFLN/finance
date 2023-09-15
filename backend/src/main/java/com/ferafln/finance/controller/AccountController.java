package com.ferafln.finance.controller;

import com.ferafln.finance.controller.dto.account.AccountRegisterRequestDTO;
import com.ferafln.finance.controller.dto.account.AccountResponseDTO;
import com.ferafln.finance.message.Message;
import com.ferafln.finance.model.Account;
import com.ferafln.finance.service.AccountService;
import com.ferafln.finance.message.I18n;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> save(@RequestBody @Valid AccountRegisterRequestDTO account){
        Account result = service.insert(account.parseToAccount());
        return ResponseEntity.ok(AccountResponseDTO.build(result));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<AccountResponseDTO>> findByUsername(@PathVariable String username){
        List<Account> result = service.findByUsername(username);
        return ResponseEntity.ok(result.stream().map(a -> AccountResponseDTO.build(a)).toList());
    }

}
