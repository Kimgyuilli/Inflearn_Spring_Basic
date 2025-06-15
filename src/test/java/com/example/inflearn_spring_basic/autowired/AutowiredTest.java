package com.example.inflearn_spring_basic.autowired;

import com.example.inflearn_spring_basic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            // @Autowired(required = true) 가 기본값이므로, noBean3은 null이 될 수 없습니다.
            // 만약 noBean3이 null이라면, 스프링 컨테이너에서 Member 타입의 빈을 찾지 못한 것입니다.
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
