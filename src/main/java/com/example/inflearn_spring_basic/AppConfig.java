package com.example.inflearn_spring_basic;

import com.example.inflearn_spring_basic.discount.FixDiscountPolicy;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import com.example.inflearn_spring_basic.member.MemoryMemberRepository;
import com.example.inflearn_spring_basic.order.OrderService;
import com.example.inflearn_spring_basic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
