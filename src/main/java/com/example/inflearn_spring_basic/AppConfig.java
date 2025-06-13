package com.example.inflearn_spring_basic;

import com.example.inflearn_spring_basic.discount.DiscountPolicy;
import com.example.inflearn_spring_basic.discount.FixDiscountPolicy;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import com.example.inflearn_spring_basic.member.MemoryMemberRepository;
import com.example.inflearn_spring_basic.order.OrderService;
import com.example.inflearn_spring_basic.order.OrderServiceImpl;

public class AppConfig {
    private static MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy getDiscountPolicy(){
        return new FixDiscountPolicy();
        // return new RateDiscountPolicy(); // 다른 할인 정책을 사용하고 싶다면 이 줄을 주석 해제하고 위의 줄을 주석 처리하세요.
    }

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }


    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }
}
