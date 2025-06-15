package com.example.inflearn_spring_basic.singletone;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하도록 함
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
