package com.example.inflearn_spring_basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{


    // 구현체에 의존하지 않고 인터페이스에 의존
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // Implementation for joining a member
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        // Implementation for finding a member by ID
        return memberRepository.findById(memberId);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
