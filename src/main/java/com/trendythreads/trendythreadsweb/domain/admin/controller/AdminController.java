package com.trendythreads.trendythreadsweb.domain.admin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/hello")
    public String helloController() {
        return "hello";
    }

}
