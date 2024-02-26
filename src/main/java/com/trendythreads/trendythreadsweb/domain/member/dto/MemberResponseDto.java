package com.trendythreads.trendythreadsweb.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {

    private Long id;

    private String name;

    private String email;

    private String profileImage;

    private Long point;

}
