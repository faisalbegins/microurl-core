package edu.miu.microurl.microurlcore.model;

abstract class PaidSubscriptionPlan extends SubscriptionPlan {
    public PaidSubscriptionPlan(double price, int restriction) {
        super(price, restriction);
    }
}
