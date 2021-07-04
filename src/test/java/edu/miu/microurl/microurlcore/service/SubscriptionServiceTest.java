package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.microurlcore.model.FreeSubscriptionPlan;
import edu.miu.microurl.microurlcore.model.Subscription;
import edu.miu.microurl.microurlcore.model.SubscriptionPlan;
import edu.miu.microurl.microurlcore.repository.SubscriptionRepository;
import edu.miu.microurl.microurlcore.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {
    @Mock
    private SubscriptionRepository repository;

    private SubscriptionService service;

    @BeforeEach
    void init() {
        service = new SubscriptionServiceImpl(repository);
    }

    @Test
    void subscriptionTest() {
        SubscriptionPlan plan = new FreeSubscriptionPlan(0, 10);
        Subscription subscribedPlan = service.subscribe(1L, plan);
        assertEquals(plan.getPrice(), subscribedPlan.getSubscriptionPlan().getPrice());
    }
}
