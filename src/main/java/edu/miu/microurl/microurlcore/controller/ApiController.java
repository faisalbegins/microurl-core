package edu.miu.microurl.microurlcore.controller;

import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.model.Subscription;
import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.service.SubscriptionService;
import edu.miu.microurl.microurlcore.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class ApiController {
    private final UrlService urlService;
    private final SubscriptionService subscriptionService;

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    public ApiController(UrlService urlService, SubscriptionService subscriptionService) {
        this.urlService = urlService;
        this.subscriptionService = subscriptionService;
    }


    @PostMapping("/subscribe")
    public Subscription subscribe() {
        //TODO: implement this Gopal
        logger.debug("request for creating subscription");
        return null;
    }

    @GetMapping("/urls")
    public List<UrlMetaData> urls() {
        logger.debug("request for getting all the urls");
        return urlService.listAllUrls();
    }

    @GetMapping("/urls/{userId}")
    public List<UrlMetaData> urls(@PathVariable Long userId,
                                  @RequestParam(defaultValue = "0") @Min(0) int page,
                                  @RequestParam(defaultValue = "5") @Max(10) int size) {
        logger.debug("request for url list for user id: [{}] from: [{}] count [{}]", userId, page, size);
        return urlService.listAllUrlsByUser(userId, page, size);
    }

    @PostMapping("/url")
    public String url(@RequestBody CreateUrlRequest request) {
        logger.debug(request.toString());
        return urlService.createShortUrlForUser(request);
    }
}
