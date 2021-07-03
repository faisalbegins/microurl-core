package edu.miu.microurl.microurlcore.model;

abstract class PaidSubscriptionPlan extends SubscriptionPlan {
    public PaidSubscriptionPlan(Double price, Integer restriction) {
        super(price, restriction);
    }
}
