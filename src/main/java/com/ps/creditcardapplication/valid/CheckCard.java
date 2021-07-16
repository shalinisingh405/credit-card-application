package com.ps.creditcardapplication.valid;

import com.ps.creditcardapplication.util.CreditCardValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CreditCardValidation.class)
@Documented
public @interface CheckCard {

    String message() default "Not a valid credit card. Please verify !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
