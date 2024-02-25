package com.trendythreads.trendythreadsweb.domain.admin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
admin 페이지의 역할
1. 모든 brand, member 의 정보를 조회하고 삭제, 초기화 할 수 있다.
 */


@RestController("admins")
public class AdminController {

    @GetMapping("/")
    public String helloController() {
        return "hello";
    }



}
