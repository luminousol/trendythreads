package com.trendythreads.trendythreadsweb.domain.admin.controller;


import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//    @GetMapping("/brands")
//    public ResponseEntity getBrands(){
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @GetMapping("/members")
//    public ResponseEntity getMembers(){
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @DeleteMapping("/{brand-id}")
//    public ResponseEntity deleteMember(@PathVariable("brand-id") Long brandId) {
//        // brand 자체를 지우는 것이 맞을지..? 정보만 지워주는 게 맞을지..?
//        brandService.deleteBrand(brandId);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }

//    @DeleteMapping("/{member-id}")
//    public ResponseEntity deleteBrand(@PathVariable("member-id") @Positive Long memberId) {
//        // member 자체를 지우는 것이 맞을지..? 정보만 지워주는 게 맞을지..?
//        memberService.deleteMember(memberId);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }

}
