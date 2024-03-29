package com.trendythreads.trendythreadsweb.domain.brand.controller;

import com.trendythreads.trendythreadsweb.domain.brand.dto.BrandPatchDto;
import com.trendythreads.trendythreadsweb.domain.brand.dto.BrandPostDto;
import com.trendythreads.trendythreadsweb.domain.brand.entity.Brand;
import com.trendythreads.trendythreadsweb.domain.brand.mapper.BrandMapper;
import com.trendythreads.trendythreadsweb.domain.brand.service.BrandService;
import com.trendythreads.trendythreadsweb.global.dto.MultiResponseDto;
import com.trendythreads.trendythreadsweb.global.dto.SingleResponseDto;
import com.trendythreads.trendythreadsweb.global.uri.UriCreator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/*
brand 페이지의 역할
1. brand 회원의 가입, 회원정보 수정, 조회, 삭제가 가능하다.
2. brand 의 수입 내역, 해당 brand 내 주문 상황을 볼 수 있다.
=> 주의 사항 : admin과 brand 회원만 접근 가능하며 가입하지 않은 자는 접근 불가하다.
=> 초기 페이지와 가입 페이지만 접근이 가능하다.
 */
@RestController
@RequestMapping("/v1/brands")
@AllArgsConstructor
@Validated
public class BrandController {

    private final static String BRAND_DEFAULT_URL = "/v1/brands";

    private final BrandMapper brandMapper;
    private final BrandService brandService;

    // 브랜드 등록
    @PostMapping("/signup")
    public ResponseEntity postBrand(@Valid @RequestBody BrandPostDto brandPostDto) {

        Brand brand = brandMapper.brandPostToBrand(brandPostDto);
        Brand createdBrand = brandService.createBrand(brand);

        URI location = UriCreator.createUri(BRAND_DEFAULT_URL, createdBrand.getId());

        return ResponseEntity.created(location).build();
    }

    // 브랜드 정보 보기 (본인, admin, 고객)
    // 브랜드 정보 연관 관계 매핑 : product, order
    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable("id") @Positive Long brandId) {
        Brand brand = brandService.readBrand(brandId);
        return new ResponseEntity(
            new SingleResponseDto<>(brandMapper.brandToBrandResponseDto(brand)),
                HttpStatus.OK);
    }

    // 주소를 이렇게 두는 게 맞는지 의문...? 나중에 생각해보기
    @GetMapping
    public ResponseEntity getBrands(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Brand> brandPage = brandService.readBrandsById(page - 1, size);
        List<Brand> brandList = brandPage.getContent();

        return new ResponseEntity(
                new MultiResponseDto<>(brandMapper.brandListToBrandResponseDto(brandList), brandPage),
                HttpStatus.OK);
    }

    // 브랜드 수정
    @PatchMapping("/mypage/{id}")
    public ResponseEntity patchBrand(@PathVariable("id") @Positive Long brandId,
                                     @Valid @RequestBody BrandPatchDto brandPatchDto) {

        brandPatchDto.setId(brandId);
        Brand brand = brandService.updateBrand(brandMapper.brandPatchToBrand(brandPatchDto));
        // responsedto 변경
        return new ResponseEntity(
                new SingleResponseDto<>(brandMapper.brandToBrandResponseDto(brand)),
                HttpStatus.OK);
    }

    // 브랜드 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable("id") @Positive Long brandId) {
        brandService.deleteBrand(brandId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
