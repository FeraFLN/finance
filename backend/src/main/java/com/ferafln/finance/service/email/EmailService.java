package com.ferafln.finance.service.email;

import com.ferafln.finance.model.EmailSend;
import com.ferafln.finance.repository.EmailRepository;
import com.ferafln.finance.service.email.process.SendEmailProcess;
import com.ferafln.finance.service.generic.process.CrudProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService extends CrudProcessService<EmailSend> {

    private final EmailRepository emailRepository;

    private final JavaMailSender mailSender;

    public void send(SimpleMailMessage mailMessage){
        SendEmailProcess process = new SendEmailProcess((mail)-> mailSender.send(mail),mailMessage );
        this.insert(process);
    }

    @Override
    public EmailRepository getRepository() {
        return emailRepository;
    }


}
