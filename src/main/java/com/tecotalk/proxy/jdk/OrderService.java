package com.tecotalk.proxy.jdk;

import com.tecotalk.proxy.jdk.Order;

public interface OrderService {
    Long save(Order order);

    void getOne(Long orderId);
}
