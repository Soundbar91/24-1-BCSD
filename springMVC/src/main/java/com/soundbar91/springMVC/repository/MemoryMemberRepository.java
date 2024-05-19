package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private final static Map<Long, Member> memberMap = new HashMap<>();
    private long currentId = 0;

    @Override
    public Member getMemberById(Long id) {
        return memberMap.get(id);
    }

    @Override
    public void addMember(Member member) {
        member.setId(currentId);
        memberMap.put(currentId++, member);
    }

}
