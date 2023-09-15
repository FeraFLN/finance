package com.ferafln.finance.message;

import com.ferafln.finance.Session;
import com.ferafln.finance.model.User;
import com.ferafln.finance.util.LangEnum;
import org.springframework.context.MessageSource;

import java.util.Objects;

public class I18n {

    public static String getMessage(String code){
        MessageSource messageSource = Session.messageSource();
        User user = Session.loggedInUser();
        if(Objects.isNull(user))
            return messageSource.getMessage(code, null, LangEnum.US.getLocale());
        return messageSource.getMessage(code, null, user.getLang().getLocale());
    }

    public static String getMessage(Message code){
        return getMessage(code.getCode());
    }
}
