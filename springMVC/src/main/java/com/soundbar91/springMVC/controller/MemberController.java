package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.MemberDTO;
import com.soundbar91.springMVC.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController() {
        this.memberService = new MemberService();
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberDTO memberDTO) {
        memberService.addMember(memberDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
