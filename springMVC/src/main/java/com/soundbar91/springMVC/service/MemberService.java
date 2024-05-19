package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.dto.MemberDTO;
import com.soundbar91.springMVC.entity.Member;
import com.soundbar91.springMVC.repository.MemberRepository;
import com.soundbar91.springMVC.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemoryMemberRepository();
    }

    public void addMember(MemberDTO memberDTO) {
        memberRepository.addMember(new Member(memberDTO.getName(), memberDTO.getEmail(), memberDTO.getPassword()));
    }
}
