package com.soundbar91.springMVC.entity;

import com.soundbar91.springMVC.dto.RequestMemberDTO;

public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateMemberInfo(RequestMemberDTO memberDTO) {
        if (memberDTO.getName() != null) this.name = memberDTO.getName();
        if (memberDTO.getEmail() != null) this.email = memberDTO.getEmail();
        if (memberDTO.getPassword() != null) this.password = memberDTO.getPassword();
    }
}
