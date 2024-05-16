package com.soundbar91.springMVC.dto;

public class Member {
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberPassWord;

    public Member(String memberId, String memberName, String memberEmail, String memberPassWord) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassWord = memberPassWord;
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
