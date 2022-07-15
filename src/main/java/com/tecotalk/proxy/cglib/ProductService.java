package com.tecotalk.proxy.cglib;

public class ProductService {
    public void save(final Product product) {
        System.out.println("정상적으로 저장되었습니다.");
    }

    public void getOne(final Long orderId) {
        System.out.println("상품 한 개를 조회했습니다.");
    }
}
