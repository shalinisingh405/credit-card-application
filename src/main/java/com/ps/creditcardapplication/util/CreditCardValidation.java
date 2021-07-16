package com.ps.creditcardapplication.util;

import com.ps.creditcardapplication.valid.CheckCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardValidation implements ConstraintValidator<CheckCard, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validCardNumber(value);
    }

    public boolean validCardNumber(String cardNumber) {

        char[] sanitsedCardNumber = sanitzedInput(cardNumber);
        int sum = 0;
        boolean isSecondDigit = false;
        for (int i = sanitsedCardNumber.length - 1; i >= 0; i--) {
            int digit = sanitsedCardNumber[i] - '0';

            if (isSecondDigit)
                digit = digit * 2;

            sum += digit / 10;
            sum += digit % 10;

            isSecondDigit = !isSecondDigit;
        }
        return sum%10==0;
    }

    private static char[] sanitzedInput(String input) {

        return input.replaceAll("[^\\d]", "").toCharArray();
    }


}
