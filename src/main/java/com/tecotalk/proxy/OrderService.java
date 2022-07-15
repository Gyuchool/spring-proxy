package com.tecotalk.proxy;

public interface OrderService {
    Long save(Order order);

    void getOne(Long orderId);
}
