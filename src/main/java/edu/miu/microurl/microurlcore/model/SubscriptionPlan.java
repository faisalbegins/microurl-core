package edu.miu.microurl.microurlcore.model;

public abstract class SubscriptionPlan {
    protected double price;
    protected int restriction;

    public SubscriptionPlan() {}

    public SubscriptionPlan(double price, int restriction) {
        this.price = price;
        this.restriction = restriction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRestriction() {
        return restriction;
    }

    public void setRestriction(int restriction) {
        this.restriction = restriction;
    }

}
