package edu.miu.microurl.microurlcore.model;

public abstract class PaidSubscriptionPlan extends SubscriptionPlan {
    public PaidSubscriptionPlan(double price, int restriction) {
        super(price, restriction);
    }
}
