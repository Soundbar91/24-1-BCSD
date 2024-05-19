package com.soundbar91.springMVC.dto;

public class MemberDTO {
    private String name;
    private String email;
    private String password;

    private MemberDTO() {
    }

    public MemberDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
