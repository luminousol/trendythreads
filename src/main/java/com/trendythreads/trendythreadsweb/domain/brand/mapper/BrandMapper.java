package com.trendythreads.trendythreadsweb.domain.brand.mapper;

import com.trendythreads.trendythreadsweb.domain.brand.dto.BrandPatchDto;
import com.trendythreads.trendythreadsweb.domain.brand.dto.BrandPostDto;
import com.trendythreads.trendythreadsweb.domain.brand.dto.BrandResponseDto;
import com.trendythreads.trendythreadsweb.domain.brand.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand brandPostToBrand(BrandPostDto brandPostDto);
    Brand brandPatchToBrand(BrandPatchDto brandPatchDto);
    BrandResponseDto brandToBrandResponseDto(Brand brand);
    List<BrandResponseDto> brandListToBrandResponseDto(List<Brand> brands);

}
