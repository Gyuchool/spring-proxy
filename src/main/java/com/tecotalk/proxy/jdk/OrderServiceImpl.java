package com.tecotalk.proxy.jdk;

public class OrderServiceImpl implements OrderService {

    @Override
    public Long save(final Order order) {
        System.out.println("정상적으로 저장되었습니다.");
        return 1L;
    }

    @Override
    public void getOne(final Long orderId) {
        System.out.println("주문 한 개를 조회했습니다.");
    }
}
