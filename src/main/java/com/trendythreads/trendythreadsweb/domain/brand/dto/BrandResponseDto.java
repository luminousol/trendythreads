package com.trendythreads.trendythreadsweb.domain.brand.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponseDto {

    private String brandId;

    private String email;

    private String name;    // 브랜드명

    private String businessNumber;    // 사업자 번호

    private String address;  // 사업장 주소

    private String homepage;    // 홈페이지 주소

    private String csNumber;     // 고객센터

    private String profileImage;    // 브랜드 프로필 이미지

}
