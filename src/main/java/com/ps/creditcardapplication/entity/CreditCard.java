package com.ps.creditcardapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "CARD_HOLDER_NAME")
    private String cardHolderName;

    @Column(name = "CARD_BALANCE")
    private int cardBalance;

    @Column(name = "CARD_LIMIT")
    private int cardLimit;

}
