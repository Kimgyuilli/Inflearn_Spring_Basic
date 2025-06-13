package com.example.inflearn_spring_basic.order;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        // Then
        // Assertions can be added here to verify the order creation
        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}
