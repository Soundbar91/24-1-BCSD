package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Member;

public interface MemberRepository {

    Member getMemberById(Long id);
    void addMember(Member member);
}
