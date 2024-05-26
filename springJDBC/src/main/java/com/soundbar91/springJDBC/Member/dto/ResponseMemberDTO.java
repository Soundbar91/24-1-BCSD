package com.soundbar91.springJDBC.Member.dto;

import com.soundbar91.springJDBC.Member.entity.Member;

public record ResponseMemberDTO(
        Long id,
        String name,
        String mail
) {
    public static ResponseMemberDTO of(Member member) {
        return new ResponseMemberDTO(
                member.getId(),
                member.getName(),
                member.getEmail());
    }
}
