package com.soundbar91.springJDBC.Member.service;

import com.soundbar91.springJDBC.Member.dto.RequestMemberDTO;
import com.soundbar91.springJDBC.Member.dto.ResponseMemberDTO;
import com.soundbar91.springJDBC.Member.entity.Member;
import com.soundbar91.springJDBC.Member.repository.JdbcTemplateMemberRepository;
import com.soundbar91.springJDBC.Member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(DataSource dataSource) {
        this.memberRepository = new JdbcTemplateMemberRepository(dataSource);
    }

    @Transactional(readOnly = true)
    public ResponseMemberDTO getMemberById(Long id) {
        return memberRepository.getMemberById(id)
                .map(ResponseMemberDTO::of)
                .orElse(null);
    }

    @Transactional
    public ResponseMemberDTO addMember(RequestMemberDTO requestMemberDTO) {
        Member member = new Member(
                requestMemberDTO.name(),
                requestMemberDTO.email(),
                requestMemberDTO.password()
        );

        memberRepository.addMember(member);
        return ResponseMemberDTO.of(member);
    }

    @Transactional
    public ResponseMemberDTO updateMember(Long id, RequestMemberDTO requestMemberDTO) {
        return memberRepository.getMemberById(id)
                .map(member -> {
                    member.updateMember(
                            requestMemberDTO.name(),
                            requestMemberDTO.email(),
                            requestMemberDTO.password()
                    );
                    memberRepository.updateMember(id, member);
                    return ResponseMemberDTO.of(member);
                })
                .orElse(null);
    }

    @Transactional
    public boolean deleteMember(Long id) {
        return memberRepository.deleteMember(id);
    }
}
