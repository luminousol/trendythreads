package com.trendythreads.trendythreadsweb.domain.brand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;    // 브랜드명

    private String email;   // 대표 메일

    private String password;    // 비밀번호

    private String businessNumber;    // 사업자 번호

    private String address;  // 사업장 주소

    private String homepage;    // 홈페이지 주소

    private String csNumber;     // 고객센터

    private String profileImage;    // 브랜드 프로필 이미지


}
