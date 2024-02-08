package com.trendythreads.trendythreadsweb.domain.category.service;

import com.trendythreads.trendythreadsweb.domain.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


}
