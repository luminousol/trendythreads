package com.trendythreads.trendythreadsweb.domain.brand.service;

import com.trendythreads.trendythreadsweb.domain.brand.entity.Brand;
import com.trendythreads.trendythreadsweb.domain.brand.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    // Create
    public Brand createBrand(Brand brand) {




        return brand;
    }

    // 가입 중복 브랜드 확인
    private boolean duplicationBrand(String businessNumber){

        List<Brand> brands = brandRepository.findByBrandBusinessNumber(businessNumber);

        if(!brands.isEmpty()) {
            throw new RuntimeException("📧 중복된 이메일입니다.");
        }
        return true;
    }

    // Read

    // Update

    // Delete


}