package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.microurlcore.model.Subscription;
import edu.miu.microurl.microurlcore.model.SubscriptionPlan;
import edu.miu.microurl.microurlcore.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription subscribe(long userId, SubscriptionPlan subscriptionPlan) {
        Subscription subscription = new Subscription();
        subscription.setUserId(userId);
        subscription.setSubscriptionPlan(subscriptionPlan);
        repository.save(subscription);
        return subscription;
    }
}
