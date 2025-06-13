package com.example.inflearn_spring_basic.beanfind;

import com.example.inflearn_spring_basic.AppConfig;
import com.example.inflearn_spring_basic.member.MemberService;
import com.example.inflearn_spring_basic.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회하기")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회하기")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회하기 X")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            ac.getBean("xxxx", MemberService.class);
        });
    }


}
