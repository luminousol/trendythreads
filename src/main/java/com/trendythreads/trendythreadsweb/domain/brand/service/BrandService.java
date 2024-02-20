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

        // 사업자 번호로 가입 중복 확인
        // ✅ 사업자 번호 유효성 검사
        duplicationBrand(brand.getBusinessNumber());

        // 이메일 확인 추후 구현

        // 사진 저장 구현

        Brand savedBrand = brandRepository.save(brand);

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
                Sort.by("brandId").descending()));
    }

    public Page<Brand> readBrandsByName(int page, int size) {
        return brandRepository.findAll(PageRequest.of(page, size,
                Sort.by("name").descending()));
    }

    // Update
    public Brand updateBrand(Brand brand) {
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면
        // 추후 아래 메서드 삭제
        Brand getBrand = readVerifiedBrand(brand.getBrandId());

        // ✅ 비밀번호, 이미지 구현 필요
        Optional.ofNullable(brand.getProfileImage()).ifPresent(image -> getBrand.setProfileImage(image));
        Optional.ofNullable(brand.getPassword()).ifPresent(password -> getBrand.setPassword(password));
        Optional.ofNullable(brand.getCsNumber()).ifPresent(csNumber -> getBrand.setCsNumber(csNumber));
        Optional.ofNullable(brand.getAdress()).ifPresent(adress -> getBrand.setAdress(adress));
//        Optional.ofNullable(member.getPassword()).ifPresent(password -> getBrand.setPassword(passwordEncoder.encode(password)));

        return brandRepository.save(getBrand);
    }

    // Delete
    public void deleteBrand(Long brandId){
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면

        Brand getBrand = readVerifiedBrand(brandId);

        brandRepository.delete(getBrand);

    }

}