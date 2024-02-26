package com.trendythreads.trendythreadsweb.domain.member.controller;

import com.trendythreads.trendythreadsweb.domain.member.dto.MemberPatchDto;
import com.trendythreads.trendythreadsweb.domain.member.dto.MemberPostDto;
import com.trendythreads.trendythreadsweb.domain.member.entity.Member;
import com.trendythreads.trendythreadsweb.domain.member.mapper.MemberMapper;
import com.trendythreads.trendythreadsweb.domain.member.service.MemberService;
import com.trendythreads.trendythreadsweb.global.dto.MultiResponseDto;
import com.trendythreads.trendythreadsweb.global.dto.SingleResponseDto;
import com.trendythreads.trendythreadsweb.global.uri.UriCreator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/*
Member 페이지의 역할
1. member 회원 가입, 회원 마이페이지, 수정, 삭제
=> 개인만 가능해야 함
 */

@RestController
@AllArgsConstructor
@RequestMapping("/v1/members")
@Validated
public class MemberController {

    private final static String MEMBER_DEFAULT_URL = "/v1/members";

    private final MemberMapper memberMapper;
    private final MemberService memberService;

    // 회원 가입
    @GetMapping("/singup")
    public ResponseEntity postMember(MemberPostDto memberPostDto){

        Member member = memberMapper.memberPostDtoToMember(memberPostDto);
        Member createdMember = memberService.createMember(member);

        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getId());

        return ResponseEntity.created(location).build();
    }

    // 회원 정보 보기
    @GetMapping("/{id}")
    public ResponseEntity getMember(@PathVariable("id") @Positive Long memberId) {
        Member member = memberService.readMember(memberId);
        return new ResponseEntity(
                new SingleResponseDto<>(memberMapper.memberToMemberResponseDto(member))
                , HttpStatus.OK);
    }

    // 주소를 이렇게 두는 게 맞는지 의문...? 나중에 생각해보기
    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Member> memberPage = memberService.readMembers(page, size);
        List<Member> memberList = memberPage.getContent();

        return new ResponseEntity(
                new MultiResponseDto<>(memberMapper.memberListToMemberResponseDto(memberList), memberPage),
                HttpStatus.OK);
    }

    // 회원 수정
    @PatchMapping("/mypage/{id}")
    public ResponseEntity patchBrand(@PathVariable("id") @Positive Long memberId,
                                     @Valid @RequestBody MemberPatchDto memberPatchDto){

        memberPatchDto.setId(memberId);
        Member member = memberService.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));

        // responsedto 변경
        return new ResponseEntity(
                new SingleResponseDto<>(memberMapper.memberToMemberResponseDto(member)),
                HttpStatus.OK);
    }

    // 회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable("id") @Positive Long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
