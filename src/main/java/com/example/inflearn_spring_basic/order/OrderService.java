package com.example.inflearn_spring_basic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
