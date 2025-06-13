package com.example.inflearn_spring_basic.discount;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; // 할인 비율

    @Override
    public int discount(Member member, int discountAmount) {
        if(member.getGrade() == Grade.VIP){
            return discountAmount * discountPercent / 100; // VIP 회원에게는 할인 비율 적용
        } else {
            return 0; // 일반 회원은 할인 없음
        }
    }
}
