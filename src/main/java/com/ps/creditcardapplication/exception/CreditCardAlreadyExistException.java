package com.ps.creditcardapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class CreditCardAlreadyExistException extends RuntimeException {
    public CreditCardAlreadyExistException(String creditCardNumber) {
        super("Credit Card Already Exist: " + creditCardNumber);
    }
}
