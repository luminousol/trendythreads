package com.trendythreads.trendythreadsweb.domain.brand.controller;

import com.trendythreads.trendythreadsweb.global.uri.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.http.HttpResponse;

@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    // 브랜드 등록
    public ResponseEntity createBrand() {

        return ResponseEntity.ok("response");
    }

    // 브랜드 수정


    // 브랜드 정보 보기 (본인, admin, 고객)
    // 브랜드 정보 연관 관계 매핑 : product, order

    // 브랜드 삭제


}
