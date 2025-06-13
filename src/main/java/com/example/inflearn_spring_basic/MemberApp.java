package com.example.inflearn_spring_basic;

import com.example.inflearn_spring_basic.member.Grade;
import com.example.inflearn_spring_basic.member.Member;
import com.example.inflearn_spring_basic.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        // 회원 생성
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원 조회
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
