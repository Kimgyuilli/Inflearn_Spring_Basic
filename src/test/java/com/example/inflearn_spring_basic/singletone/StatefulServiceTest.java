package com.example.inflearn_spring_basic.singletone;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // Thread A: 사용자 A가 10,000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // Thread B: 사용자 B가 20,000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);


        // Thread A: 사용자 A가 주문 금액을 조회
//        int price = statefulService1.getPrice(); // 사용자 A가 주문한 금액을 조회
        System.out.println("price = " + userAPrice);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
         @Bean
         public StatefulService statefulService() {
             return new StatefulService();
         }
    }
}