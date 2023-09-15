package com.ferafln.finance.controller;

import com.ferafln.finance.model.EmailSend;
import com.ferafln.finance.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    private final EmailService service;

    @GetMapping
    public ResponseEntity<String> hello(@RequestBody EmailSend emailSent){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Send email test!");
        mailMessage.setTo("fernando.limeira.n@gmail.com", "lina.galvao85@gmail.com");
        mailMessage.setText("Sending email test form gym.ferafln app!");
//        mailSender.send(mailMessage);
        service.send(mailMessage);

        return ResponseEntity.ok(emailSent.getUser().getUsername());
    }
}
