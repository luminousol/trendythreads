package com.trendythreads.trendythreadsweb.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPatchDto {

    private Long id;

    @NotBlank(message = "닉네임(이름)은 공백이 아니어야 합니다.")
    private String name;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$",
            message = "비밀번호는 8자리 이상 숫자, 문자, 특수문자 조합으로 입력해야 합니다.")
    private String password;

    @Pattern(regexp = "^010\\d{4}\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자로 구성되어야 합니다.")
    private String phone;


    private String profileImage;

}
