package com.trendythreads.trendythreadsweb.domain.brand.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class BrandPostDto {

    @NotBlank(message = "브랜드명은 필수값입 니다.")
    @NotNull
    private String name;

    @Email(message = "이메일 형식으로 작성해주세요. email@example.com")
    @NotNull
    private String email;   // 대표 메일

    @NotNull(message = "비밀번호는 필수값입 니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$",
            message = "비밀번호는 8자리 이상 숫자, 문자, 특수문자 조합으로 입력해야 합니다.")
    private String password;    // 비밀번호

    @NotNull
    @Pattern(regexp = "^\\d{9}$", message = "사업자 번호는 - 없이 숫자만 9자리 입력해주세요.")
    private String businessNumber;    // 사업자 번호

    @NotBlank(message = "주소는 필수값 입니다.")
    private String address;  // 사업장 주소

    @NotBlank(message = "홈페이지 주소는 필수값 입니다.")
    private String homepage;    // 홈페이지 주소

    @NotBlank(message = "고객센터 번호는 필수값 입니다.")
    private String csNumber;     // 고객센터

}
