package com.trendythreads.trendythreadsweb.domain.brand.repository;

import com.trendythreads.trendythreadsweb.domain.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    List<Brand> findByBrandBusinessNumber(String businessNumber);

}
