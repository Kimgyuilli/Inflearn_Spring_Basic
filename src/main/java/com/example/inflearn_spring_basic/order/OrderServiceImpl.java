package com.example.inflearn_spring_basic.order;

import com.example.inflearn_spring_basic.annotation.MainDiscountPolicy;
import com.example.inflearn_spring_basic.discount.DiscountPolicy;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);
        // 주문 생성 로직
        // 예시로 간단히 주문 객체를 생성하여 반환
        return new Order(memberId, itemName, itemPrice, discount);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
