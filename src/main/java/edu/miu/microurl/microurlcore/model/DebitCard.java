package edu.miu.microurl.microurlcore.model;

public class DebitCard extends PaymentMethod{

    private int cardNumber;
    public CardType cardType;

    public DebitCard(int cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }


}
