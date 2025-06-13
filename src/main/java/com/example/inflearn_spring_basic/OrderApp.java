package com.example.inflearn_spring_basic;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.order.Order;
import com.example.inflearn_spring_basic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        // AppConfig를 통해 의존관계 주입
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        // 회원 생성
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("new member = " + itemA);
    }
}
