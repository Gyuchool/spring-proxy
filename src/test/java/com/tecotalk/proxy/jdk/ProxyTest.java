package com.tecotalk.proxy.jdk;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProxyTest {

    @DisplayName("메서드 이름이 get으로 시작하면 jdk 프록시가 동작한다.")
    @Test
    void jdkProxy() {
        OrderService orderService = (OrderService) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),   //프록시 로딩에 사용할 클래스로더
                new Class[]{OrderService.class}, //타깃의 interface
                new LoggingHandler(new OrderServiceImpl())); //부가 기능과 위임할 타겟
        Long orderId = orderService.save(new Order());
        orderService.getOne(orderId);
        System.out.println(orderService.getClass());
    }

    @DisplayName("메서드 이름이 get으로 시작하지 않으면 조회 로그를 찍지 않는다.")
    @Test
    void jdkProxyFailureWhenMethodNameIncorrect() {
        OrderService orderService = (OrderService) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{OrderService.class},
                new LoggingHandler(new OrderServiceImpl()));

        orderService.save(new Order());
    }
}
