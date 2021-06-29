package edu.miu.microurl.microurlcore.controller;

import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return service.listAllUrls();
    }

    @PostMapping("/url")
    public String url(@RequestBody CreateUrlRequest request) {
        logger.debug(request.toString());
        return service.createShortUrlForUser(request);
    }
}
