package edu.miu.microurl.microurlcore.controller;

import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final UrlService service;
    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    public ApiController(UrlService service) {
        this.service = service;
    }

    @GetMapping("/urls")
    public List<UrlMetaData> urls() {
        logger.debug("request for getting all the urls");
        return service.listAllUrls();
    }

    @GetMapping("/urls/{userId}")
    public List<UrlMetaData> urls(@PathVariable @NotBlank Long userId,
                                  @RequestParam(defaultValue = "0") @Min(0) int page,
                                  @RequestParam(defaultValue = "5") @Max(10) int size) {
        logger.debug("request for url list for user id: [{}] from: [{}] count [{}]", userId, page, size);
        return service.listAllUrlsByUser(userId, page, size);
    }

    @PostMapping("/url")
    public String url(@RequestBody CreateUrlRequest request) {
        logger.debug(request.toString());
        return service.createShortUrlForUser(request);
    }
}
