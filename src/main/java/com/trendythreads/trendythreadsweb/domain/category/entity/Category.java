package com.trendythreads.trendythreadsweb.domain.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    private String name;    // 카테고리 이름

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory; // 상위 카테고리

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> childCategories = new HashSet<>();    // 하위 카테고리

}