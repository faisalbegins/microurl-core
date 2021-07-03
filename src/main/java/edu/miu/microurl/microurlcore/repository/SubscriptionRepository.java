package edu.miu.microurl.microurlcore.repository;

import edu.miu.microurl.microurlcore.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> { }
