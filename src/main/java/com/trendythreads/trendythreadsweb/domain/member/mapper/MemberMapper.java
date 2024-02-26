package com.trendythreads.trendythreadsweb.domain.member.mapper;

import com.trendythreads.trendythreadsweb.domain.member.dto.MemberPatchDto;
import com.trendythreads.trendythreadsweb.domain.member.dto.MemberPostDto;
import com.trendythreads.trendythreadsweb.domain.member.dto.MemberResponseDto;
import com.trendythreads.trendythreadsweb.domain.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);

    List<MemberResponseDto> memberListToMemberResponseDto(List<Member> memberList);

}
