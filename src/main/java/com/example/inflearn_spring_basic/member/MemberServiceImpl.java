package com.example.inflearn_spring_basic.member;

public class MemberServiceImpl implements MemberService{


    // 구현체에 의존하지 않고 인터페이스에 의존
    private final MemberRepository memberRepository;

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
}
