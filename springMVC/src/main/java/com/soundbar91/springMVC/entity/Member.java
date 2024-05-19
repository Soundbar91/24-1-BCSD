package com.soundbar91.springMVC.entity;

import com.soundbar91.springMVC.dto.MemberDTO;

public class Member {
    private long id;
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberPassWord;

    public Member(long id, MemberDTO memberDTO) {
        this.id = id;
        this.memberId = memberDTO.getMemberId();
        this.memberName = memberDTO.getMemberName();
        this.memberEmail = memberDTO.getMemberEmail();
        this.memberPassWord = memberDTO.getMemberPassWord();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassWord() {
        return memberPassWord;
    }

    public void setMemberPassWord(String memberPassWord) {
        this.memberPassWord = memberPassWord;
    }
}
