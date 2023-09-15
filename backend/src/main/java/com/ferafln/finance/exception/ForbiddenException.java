package com.ferafln.finance.exception;

import com.ferafln.finance.message.I18n;
import com.ferafln.finance.message.Message;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ForbiddenException extends FinanceException{
    public ForbiddenException() {
        super(Message.FORBIDDEN);
    }

    public ForbiddenException(Message message) {
        super(message);
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
