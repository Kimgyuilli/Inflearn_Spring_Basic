package com.example.inflearn_spring_basic.singletone;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 상태를 유지
        return price;
    }

//    public int getPrice() {
//        return price; // 상태를 반환
//    }
}
