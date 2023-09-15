package com.ferafln.finance.service.email.process;

import com.ferafln.finance.model.EmailSend;
import com.ferafln.finance.service.generic.process.InsertProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class SendEmailProcess extends InsertProcess<EmailSend> {
    private final Consumer<SimpleMailMessage> preProcess;
    private final SimpleMailMessage mailMessage;

    @Override
    public Boolean preInsertAction() {
        preProcess.accept(mailMessage);
        return true;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public EmailSend getEntity() {
        return EmailSend.builder()
                .sendTo(String.join(", ",mailMessage.getTo()))
                .sendFrom( mailMessage.getFrom())
                .text(mailMessage.getText())
                .subject(mailMessage.getSubject())
//                .sendCC(String.join(", ",mailMessage.getCc()))
                .build();
    }


//    private Predicate<SimpleMailMessage> preProcess;


}
