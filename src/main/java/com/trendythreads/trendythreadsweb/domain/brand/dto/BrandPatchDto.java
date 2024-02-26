package com.trendythreads.trendythreadsweb.domain.brand.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandPatchDto {

    private Long id;

    private String profileImage;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$",
            message = "비밀번호는 8자리 이상 숫자, 문자, 특수문자 조합으로 입력해야 합니다.")
    private String password;    // 비밀번호

    @NotBlank(message = "주소는 공백이 아니어야 합니다.")
    private String address;  // 사업장 주소

    @NotBlank(message = "고객센터 번호는 공백이 아니어야 합니다.")
    private String csNumber;     // 고객센터

}
