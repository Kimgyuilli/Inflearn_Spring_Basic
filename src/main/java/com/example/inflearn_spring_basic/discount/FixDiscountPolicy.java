package com.example.inflearn_spring_basic.discount;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discounFixAmount = 1000; // 고정 할인 금액

    @Override
    public int discount(Member member, int discountAmount) {

        if(member.getGrade() == Grade.VIP) {
            return discounFixAmount; // VIP 회원에게는 고정 할인 금액 적용
        }else {
            return 0;
        }
    }
}
