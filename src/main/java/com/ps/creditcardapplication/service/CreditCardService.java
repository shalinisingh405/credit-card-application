package com.ps.creditcardapplication.service;

import com.ps.creditcardapplication.entity.CreditCard;
import com.ps.creditcardapplication.request.CreditCardRequest;

import java.util.List;

public interface CreditCardService {

   CreditCard add(CreditCardRequest creditCardRequest);
   List<CreditCard> getAll();

}
