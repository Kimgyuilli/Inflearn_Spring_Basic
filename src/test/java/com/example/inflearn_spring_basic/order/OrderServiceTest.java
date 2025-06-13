package com.example.inflearn_spring_basic.order;

import com.example.inflearn_spring_basic.AppConfig;
import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {

    // AppConfig를 사용하지 않고 직접 구현체를 생성
    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

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
