package com.example.inflearn_spring_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) // @Configuration 어노테이션이 붙은 클래스는 스캔하지 않도록 설정
)
public class AutoAppConfig {
    // @ComponentScan은 기본적으로 현재 패키지와 하위 패키지를 스캔합니다.
    // 따라서 이 클래스가 있는 패키지와 그 하위 패키지에 있는 모든 @Component, @Service, @Repository, @Controller 등이 자동으로 스캔되어 빈으로 등록됩니다.
    // 예를 들어, com.example.inflearn_spring_basic.member 패키지에 있는 클래스들도 자동으로 빈으로 등록됩니다.
    // 만약 특정 패키지만 스캔하고 싶다면 @ComponentScan(basePackages = "com.example.inflearn_spring_basic.member")와 같이 사용할 수 있습니다.
    // @Configuration은 이 클래스가 스프링의 설정 클래스를 나타내며, 빈 정의를 포함할 수 있음을 나타냅니다.
    // 이 설정 클래스는 @ComponentScan을 통해 자동으로 빈을 등록하는 역할을 합니다.
    // @ComponentScan은 스프링이 자동으로 빈을 등록할 때 사용하는 어노테이션입니다.

}
