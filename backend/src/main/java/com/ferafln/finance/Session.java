package com.ferafln.finance;

import com.ferafln.finance.model.User;
import com.ferafln.finance.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class Session {

    private static MessageSource messageSource;

    public Session(MessageSource messageSource) {
        Session.messageSource = messageSource;
    }

    public final static MessageSource messageSource(){
        return messageSource;
    }
    public final static User loggedInUser(){
        if(Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){
            return null;
        }
        if("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName())){
            return null;
        }
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
