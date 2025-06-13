package com.example.inflearn_spring_basic;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import com.example.inflearn_spring_basic.order.Order;
import com.example.inflearn_spring_basic.order.OrderService;
import com.example.inflearn_spring_basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // 회원 생성
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("new member = " + itemA);
    }
}
