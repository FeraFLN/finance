package com.ferafln.finance.exception;

import com.ferafln.finance.Session;
import com.ferafln.finance.exception.ForbiddenException;
import com.ferafln.finance.exception.HandledException;
import com.ferafln.finance.message.I18n;
import com.ferafln.finance.util.LangEnum;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = I18n.getMessage(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public HandledException handleForbiddenExceptions(ForbiddenException ex) {
        String msg = ex.getMessage();
        if(ex.getMessageI18n() != null){
            msg = I18n.getMessage(ex.getMessageI18n());
        }
        return new HandledException(HttpStatus.FORBIDDEN.value(), new String[]{msg});
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FinanceException.class)
    public HandledException handleForbiddenExceptions(FinanceException ex) {
        String msg = ex.getMessage();
        if(ex.getMessageI18n() != null){
            msg = I18n.getMessage(ex.getMessageI18n());
        }
        return new HandledException(HttpStatus.BAD_REQUEST.value(), new String[]{msg});
    }
}
