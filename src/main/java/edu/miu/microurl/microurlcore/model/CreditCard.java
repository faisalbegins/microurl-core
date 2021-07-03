package edu.miu.microurl.microurlcore.model;

public class CreditCard extends PaymentMethod{

    private int cardNumber;
    public CardType cardType;


    public CreditCard(int cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
