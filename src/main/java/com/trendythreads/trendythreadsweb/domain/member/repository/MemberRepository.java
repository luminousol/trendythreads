package com.trendythreads.trendythreadsweb.domain.member.repository;

import com.trendythreads.trendythreadsweb.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByPhone(String phone);

}
