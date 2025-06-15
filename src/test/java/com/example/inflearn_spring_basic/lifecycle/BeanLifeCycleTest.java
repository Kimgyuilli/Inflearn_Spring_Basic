package com.example.inflearn_spring_basic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // Bean의 생명주기를 테스트하는 코드를 작성할 수 있습니다.
        // 예를 들어, @PostConstruct, @PreDestroy 어노테이션을 사용하여
        // 빈의 초기화 및 소멸 메서드를 테스트할 수 있습니다.

        // 이 예제에서는 구체적인 구현 없이 테스트 메서드만 정의합니다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        // 이 클래스는 Bean의 생명주기를 관리하는 설정 클래스로 사용할 수 있습니다.
        // 예를 들어, @Bean 어노테이션을 사용하여 빈을 정의하고,
        // @PostConstruct 및 @PreDestroy 어노테이션을 사용하여 초기화 및 소멸 메서드를 정의할 수 있습니다.
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
