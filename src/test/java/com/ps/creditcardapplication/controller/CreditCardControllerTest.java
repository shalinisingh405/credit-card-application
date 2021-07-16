package com.ps.creditcardapplication.controller;

import com.ps.creditcardapplication.BaseTest;
import com.ps.creditcardapplication.request.CreditCardRequest;
import com.ps.creditcardapplication.service.CreditCardService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.ps.creditcardapplication.util.TestUtils.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest extends BaseTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreditCardService creditCardService;

    @Test
    public void givenValidCreditCardDetails_thenCreateCreditCard() throws Exception {

        mvc.perform(post("/api/creditCards")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(getValidCardDetails())))
                .andExpect(status().isCreated());

        ArgumentCaptor<CreditCardRequest> creditCardCaptor = ArgumentCaptor.forClass(CreditCardRequest.class);
        verify(creditCardService, times(1)).add(creditCardCaptor.capture());
    }

    @Test
    public void givenInValidCreditCardDetails_thenThrowException() throws Exception {
        mvc.perform(post("/api/creditCards")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(getInvalidCardDetails())))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void givenValidCall_thenReturnAllCards() throws Exception {
        mvc.perform(get("/api/creditCards"))
                .andExpect(status().isOk());

    }
}
