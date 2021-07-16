package com.ps.creditcardapplication.request;

import com.ps.creditcardapplication.valid.CheckCard;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreditCardRequest {

    @NotNull(message = "Please provide a name")
    private String cardHolderName;

    @Pattern(regexp = "^[0-9]*$", message = "This is a Credit Card Number. Please enter only digit")
    @Size(min = 13, max = 19)
    @CheckCard
    private String creditCardNumber;

    @NotNull
    private int creditCardLimit;
}
