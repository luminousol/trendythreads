package com.trendythreads.trendythreadsweb.global.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

// 여러 개의 response를 담아내는 dto
@Getter
public class MultiResponseDto<T> {
    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page page) {
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber() + 1,
                page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
