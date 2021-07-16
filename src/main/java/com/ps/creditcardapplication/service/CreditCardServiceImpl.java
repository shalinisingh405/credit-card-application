package com.ps.creditcardapplication.service;

import com.ps.creditcardapplication.entity.CreditCard;
import com.ps.creditcardapplication.exception.CreditCardAlreadyExistException;
import com.ps.creditcardapplication.repository.CreditCardRepository;
import com.ps.creditcardapplication.request.CreditCardRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Resource
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard add(CreditCardRequest creditCardRequest) {

        String creditCardNumber = creditCardRequest.getCreditCardNumber();

        if (creditCardRepository.findByCardNumber(creditCardNumber).isPresent())
            throw new CreditCardAlreadyExistException(creditCardNumber);

        return creditCardRepository.save(getCreditCardEntity(creditCardRequest));

    }

    @Override
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    private CreditCard getCreditCardEntity(CreditCardRequest creditCardRequest) {
        return CreditCard.builder()
                .cardBalance(0)
                .cardHolderName(creditCardRequest.getCardHolderName())
                .cardNumber(creditCardRequest.getCreditCardNumber())
                .cardLimit(creditCardRequest.getCreditCardLimit()).
                        build();
    }

}
