package com.trendythreads.trendythreadsweb.domain.member.service;

import com.trendythreads.trendythreadsweb.domain.member.entity.Member;
import com.trendythreads.trendythreadsweb.domain.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    public Member createMember(Member member) {

        checkMemberDuplication(member.getPhone());

        // 이메일 확인 추후 구현

        return memberRepository.save(member);
    }


    private boolean checkMemberDuplication(String phone){
        List<Member> members = memberRepository.findByPhone(phone);

        if(!members.isEmpty()) {
            throw new RuntimeException("이미 가입된 사용자입니다.");
        }
        return true;
    }

    // 회원 읽기 -> 해당 회원만 볼 수 있게 해야함
    public Member readMember(Long memberId) {

        return readVerifiedMember(memberId);
    }

    public Member readVerifiedMember(Long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() -> new RuntimeException("🚨 회원 정보를 찾을 수 없습니다."));

        return findMember;
    }

    public Page<Member> readMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("id").descending()));
    }

    // 회원 수정
    public Member updateMember(Member member) {
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면

        Member getMember = readVerifiedMember(member.getId());

        Optional.ofNullable(member.getName()).ifPresent(name -> getMember.setName(name));
        Optional.ofNullable(member.getPassword()).ifPresent(password -> getMember.setPassword(password));
        Optional.ofNullable(member.getProfileImage()).ifPresent(image -> getMember.setProfileImage(image));

        if(member.getPhone() != null && checkMemberDuplication(member.getPhone())) {
            getMember.setPhone(member.getPhone());
        }

        return memberRepository.save(member);
    }

    // 회원 삭제
    public void deleteMember(Member member) {
        // ✅ 비밀번호 검증 후 진행 => Authorized 된 사용자라면

        Member getMember = readVerifiedMember(member.getId());

        memberRepository.delete(member);
    }

}
