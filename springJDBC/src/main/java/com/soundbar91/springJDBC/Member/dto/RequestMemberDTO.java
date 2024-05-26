package com.soundbar91.springJDBC.Member.dto;

public record RequestMemberDTO(
        String name,
        String email,
        String password
) {

}
