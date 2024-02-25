package com.trendythreads.trendythreadsweb.domain.brand.service;

import com.trendythreads.trendythreadsweb.domain.brand.entity.Brand;
import com.trendythreads.trendythreadsweb.domain.brand.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    // Create
    public Brand createBrand(Brand brand) {

        duplicationBrand(brand.getBusinessNumber());

        // 이메일 확인 추후 구현

        // 사진 저장 구현

        return brandRepository.save(brand);
    }

    // 가입 중복 브랜드 확인
    private boolean duplicationBrand(String businessNumber){

        List<Brand> brands = brandRepository.findByBusinessNumber(businessNumber);

        if(!brands.isEmpty()) {
            throw new RuntimeException("이미 가입된 브랜드(사용자)입니다.");
        }
        return true;
    }

    // Read -> dto 다르게 해서 브랜드 정보만 보여주는 거, 본인이 보는 거 다르게 하기
    public Brand readBrand(Long brandId) {

        return readVerifiedBrand(brandId);
    }

    public Brand readVerifiedBrand(Long brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        Brand findBrand = optionalBrand.orElseThrow(() -> new RuntimeException("🚨 브랜드를 찾을 수 없습니다."));

        return findBrand;
    }

    public Page<Brand> readBrandsById(int page, int size) {
        return brandRepository.findAll(PageRequest.of(page, size,
                Sort.by("id").descending()));
    }

    public Page<Brand> readBrandsByName(int page, int size) {
        return brandRepository.findAll(PageRequest.of(page, size,
                Sort.by("name").descending()));
    }

    // Update
    public Brand updateBrand(Brand brand) {
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면

        Brand getBrand = readVerifiedBrand(brand.getId());

        // ✅ 비밀번호, 이미지 구현 필요
        Optional.ofNullable(brand.getProfileImage()).ifPresent(image -> getBrand.setProfileImage(image));
        Optional.ofNullable(brand.getPassword()).ifPresent(password -> getBrand.setPassword(password));
        Optional.ofNullable(brand.getCsNumber()).ifPresent(csNumber -> getBrand.setCsNumber(csNumber));
        Optional.ofNullable(brand.getAddress()).ifPresent(address -> getBrand.setAddress(address));
//        Optional.ofNullable(member.getPassword()).ifPresent(password -> getBrand.setPassword(passwordEncoder.encode(password)));

        return brandRepository.save(brand);
    }

    // Delete
    public void deleteBrand(Long brandId){
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면

        Brand getBrand = readVerifiedBrand(brandId);

        brandRepository.delete(getBrand);

    }

}