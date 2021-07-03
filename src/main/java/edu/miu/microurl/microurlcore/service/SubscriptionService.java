package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.microurlcore.model.Subscription;
import edu.miu.microurl.microurlcore.model.SubscriptionPlan;


public interface SubscriptionService  {
    public Subscription subscribeFreePlan(long userId, SubscriptionPlan subscriptionPlan);
}
