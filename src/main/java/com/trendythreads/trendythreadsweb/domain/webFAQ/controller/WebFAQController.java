package com.trendythreads.trendythreadsweb.domain.webFAQ.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WebFAQController {
    @GetMapping("/")
    public String helloController() {
        return "hello";
    }



}
