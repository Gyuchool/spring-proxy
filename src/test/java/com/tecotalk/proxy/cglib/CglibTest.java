package com.tecotalk.proxy.cglib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @DisplayName("메서드 이름이 get으로 시작하면 '조회 메소드 호출!!!'을 출력하는 CGLIB 프록시가 동작한다.")
    @Test
    void cglibProxyWhenGET() {
        ProductService productService = (ProductService)Enhancer.create(
                ProductService.class,
                new LoggingMethodInterceptor(new ProductService())
        );

        productService.getOne(1L);
        System.out.println(productService.getClass());
    }

    @DisplayName("메서드 이름이 get으로 시작하지 않으면 조회 메소드 호출이 아님을 출력하는 CGLIB 프록시가 동작한다.")
    @Test
    void cglibProxy() {
        ProductService productService = (ProductService)Enhancer.create(
                ProductService.class,
                new LoggingMethodInterceptor(new ProductService())
        );

        productService.save(new Product());
        System.out.println(productService.getClass());
    }
}
