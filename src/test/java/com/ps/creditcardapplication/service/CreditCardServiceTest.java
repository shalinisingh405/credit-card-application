package com.ps.creditcardapplication.service;

import com.ps.creditcardapplication.entity.CreditCard;
import com.ps.creditcardapplication.exception.CreditCardAlreadyExistException;
import com.ps.creditcardapplication.repository.CreditCardRepository;
import com.ps.creditcardapplication.request.CreditCardRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditCardServiceTest {

    @Autowired
    private CreditCardService creditCardService;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @Test
    public void checkIfCardDoesNotExist_createOneSuccessfully() {
        // this mock creditCardRepository and return empty response
        when(creditCardRepository.findByCardNumber(Mockito.anyString())).
                thenReturn(Optional.empty());

        creditCardService.add(getCardRequest());
    }

    @Test
    public void checkIfCardExist_throwError() {
        when(creditCardRepository.findByCardNumber(Mockito.anyString())).
                thenReturn(Optional.of(getCardDetails()));

        assertThrows(CreditCardAlreadyExistException.class,
                () -> creditCardService.add(getCardRequest()));

    }

    @Test
    public void getAllcards() {

        List<CreditCard> creditCardList = Arrays.asList(getCardDetails());
        when(creditCardRepository.findAll()).
                thenReturn(creditCardList);

        assertEquals(creditCardService.getAll(), creditCardList);

    }

    private CreditCardRequest getCardRequest() {
        CreditCardRequest creditCardRequest = new CreditCardRequest();
        creditCardRequest.setCreditCardLimit(2000);
        creditCardRequest.setCreditCardNumber("21323123123");
        creditCardRequest.setCardHolderName("Sample_Card_Name");
        return creditCardRequest;
    }

    private CreditCard getCardDetails() {

        return CreditCard.builder().cardLimit(2000).
                cardNumber("21323123123").
                cardHolderName("Sample_Card_Name").
                build();

    }
}
