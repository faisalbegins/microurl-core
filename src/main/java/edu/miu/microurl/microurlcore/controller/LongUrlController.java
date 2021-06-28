package edu.miu.microurl.microurlcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LongUrlController {

    @GetMapping("/{shortUrl}")
    public String longUrl(@PathVariable("shortUrl") String shortUrl) {
        return shortUrl;
    }
}
