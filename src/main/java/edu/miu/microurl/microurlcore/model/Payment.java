package edu.miu.microurl.microurlcore.model;
import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate;
    private double amount;

    public Payment(LocalDate paymentDate, double amount) {
        this.paymentDate = paymentDate;
        this.amount = amount;
    }


    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
