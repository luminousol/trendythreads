package com.trendythreads.trendythreadsweb.domain.category.repository;

import com.trendythreads.trendythreadsweb.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
