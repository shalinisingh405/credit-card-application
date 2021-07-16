package com.ps.creditcardapplication.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.creditcardapplication.request.CreditCardRequest;

public class TestUtils {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static CreditCardRequest getInvalidCardDetails() {
        CreditCardRequest creditCardRequest = new CreditCardRequest();
        creditCardRequest.setCreditCardLimit(2000);
        creditCardRequest.setCreditCardNumber("21323123123");
        creditCardRequest.setCardHolderName("Sample_Card_Name");
        return creditCardRequest;
    }

    public static CreditCardRequest getValidCardDetails() {
        CreditCardRequest creditCardRequest = new CreditCardRequest();
        creditCardRequest.setCreditCardLimit(2000);
        creditCardRequest.setCreditCardNumber("345829915896753");
        creditCardRequest.setCardHolderName("Sample_Card_Name");
        return creditCardRequest;
    }
}
