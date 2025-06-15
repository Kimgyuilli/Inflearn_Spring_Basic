package com.example.inflearn_spring_basic.singletone;

import com.example.inflearn_spring_basic.AppConfig;
import com.example.inflearn_spring_basic.member.MemberRepository;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import com.example.inflearn_spring_basic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {


    @Test
    void configurationTest() {
        // Given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("getMemberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository MemberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository1);
        System.out.println("orderMemberRepository = " + MemberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(MemberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository);

    }
}
