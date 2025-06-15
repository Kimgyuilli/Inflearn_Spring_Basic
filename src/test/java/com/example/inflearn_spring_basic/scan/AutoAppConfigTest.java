package com.example.inflearn_spring_basic.scan;

import com.example.inflearn_spring_basic.AutoAppConfig;
import com.example.inflearn_spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        // 스프링 컨테이너를 생성하고, 자동으로 빈을 등록하는 테스트를 작성할 수 있습니다.
        // 예시로, @SpringBootTest를 사용하여 전체 애플리케이션 컨텍스트를 로드할 수 있습니다.
        // 하지만 이 예제에서는 구체적인 구현 없이 테스트 메서드만 정의합니다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
