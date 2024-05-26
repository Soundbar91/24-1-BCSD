package com.soundbar91.springJDBC.Member.repository;

import com.soundbar91.springJDBC.Member.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> getMemberById(Long id);
    void addMember(Member member);
    void updateMember(Long id, Member member);
    boolean deleteMember(Long id);
}
