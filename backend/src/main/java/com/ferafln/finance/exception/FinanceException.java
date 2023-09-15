package com.ferafln.finance.exception;

import com.ferafln.finance.message.Message;

public class FinanceException extends RuntimeException{
    private Message message;
    public FinanceException() {
    }

    public FinanceException(Message message) {
        super(message.getCode());
        this.message = message;
    }

    public FinanceException(String message) {
        super(message);
    }

    public FinanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinanceException(Throwable cause) {
        super(cause);
    }

    public FinanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public Message getMessageI18n() {
        return message;
    }
}
