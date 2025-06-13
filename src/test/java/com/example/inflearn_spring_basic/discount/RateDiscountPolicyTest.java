package com.example.inflearn_spring_basic.discount;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // Given
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discountAmount = 10000; // 할인 대상 금액

        // When
        int discount = rateDiscountPolicy.discount(member, discountAmount);

        // Then
        assertEquals(1000, discount); // 10% 할인 적용
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // Given
        Member member = new Member(2L, "memberB", Grade.BASIC);
        int discountAmount = 10000; // 할인 대상 금액

        // When
        int discount = rateDiscountPolicy.discount(member, discountAmount);

        // Then
        assertEquals(0, discount); // 할인 적용되지 않음
    }

}