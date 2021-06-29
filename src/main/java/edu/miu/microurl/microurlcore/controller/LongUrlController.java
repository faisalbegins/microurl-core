package edu.miu.microurl.microurlcore.controller;

import edu.miu.microurl.microurlcore.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class LongUrlController {
    private final UrlService service;

    Logger logger = LoggerFactory.getLogger(LongUrlController.class);

    @Autowired
    public LongUrlController(UrlService service) {
        this.service = service;
    }

    @GetMapping("/{shortUrl}")
    public ModelAndView longUrl(@PathVariable("shortUrl") String shortUrl) {
        String longUrl = service.longUrl(shortUrl);
        logger.debug("Redirecting to: " + longUrl);
        return new ModelAndView("redirect:" + longUrl);
    }
}
