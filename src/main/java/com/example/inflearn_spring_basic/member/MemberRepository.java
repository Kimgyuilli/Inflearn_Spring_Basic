package com.example.inflearn_spring_basic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
