package com.ps.creditcardapplication.util;

import junitparams.JUnitParamsRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CreditCardValidationsTest {

    @ParameterizedTest
    @CsvSource({
            "'2333123123',false",
            "'345133514383127',true",
            "'345133514383126',false",
            "'345829915896753',true",
            "'375590845465944',true",
            "'370294919445040',true",
            "'stringasdadasd',true"
    })
    public void isValidCreditCard(String input, boolean result){
        CreditCardValidation creditCardValidation = new CreditCardValidation();
        assertEquals(creditCardValidation.validCardNumber(input), result);
    }
}
