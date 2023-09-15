package com.ferafln.finance.exception;

import com.ferafln.finance.message.Message;

public class UniqueConstraintException extends FinanceException{
    public UniqueConstraintException() {
    }

    public UniqueConstraintException(Message message) {
        super(message);
    }

    public UniqueConstraintException(String message) {
        super(message);
    }

    public UniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueConstraintException(Throwable cause) {
        super(cause);
    }

    public UniqueConstraintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
