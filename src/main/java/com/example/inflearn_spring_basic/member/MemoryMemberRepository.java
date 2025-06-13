package com.example.inflearn_spring_basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // Using a simple map for in-memory storage

    @Override
    public void save(Member member) {
        // Implementation for saving a member in memory
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        // Implementation for finding a member by ID in memory
        return store.get(memberId);
    }
}
