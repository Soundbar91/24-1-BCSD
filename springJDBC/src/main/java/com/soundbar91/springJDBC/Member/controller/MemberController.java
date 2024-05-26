package com.soundbar91.springJDBC.Member.controller;

import com.soundbar91.springJDBC.Member.dto.RequestMemberDTO;
import com.soundbar91.springJDBC.Member.dto.ResponseMemberDTO;
import com.soundbar91.springJDBC.Member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(DataSource dataSource) {
        this.memberService = new MemberService(dataSource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMemberDTO> getMemberById(@PathVariable("id") Long id) {
        ResponseMemberDTO member = memberService.getMemberById(id);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<ResponseMemberDTO> createMember(@RequestBody RequestMemberDTO member) {
        ResponseMemberDTO responseMemberDTO = memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMemberDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMemberDTO> updateMember(@PathVariable("id") Long id, @RequestBody RequestMemberDTO member) {
        ResponseMemberDTO responseMemberDTO = memberService.updateMember(id, member);
        return responseMemberDTO != null ? ResponseEntity.ok(responseMemberDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMemberDTO> deleteMember(@PathVariable("id") Long id) {
        return memberService.deleteMember(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
