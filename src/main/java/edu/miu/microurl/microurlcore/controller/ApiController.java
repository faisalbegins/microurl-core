package edu.miu.microurl.microurlcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/urls")
    public String urls() {
        return "list all the urls";
    }

    @GetMapping("/test")
    public String test() {
        return "this is test";
    }
}
