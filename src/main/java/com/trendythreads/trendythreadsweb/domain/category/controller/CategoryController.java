package com.trendythreads.trendythreadsweb.domain.category.controller;

import com.trendythreads.trendythreadsweb.domain.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


}
