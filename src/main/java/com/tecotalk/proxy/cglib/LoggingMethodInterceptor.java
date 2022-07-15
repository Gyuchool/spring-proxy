package com.tecotalk.proxy.cglib;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

@Slf4j
public class LoggingMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public LoggingMethodInterceptor(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if (method.getName().startsWith("get")) {
            log.info("Executing {} method : {}", method.getName(), "조회 메서드 호출!!!");
            return methodProxy.invoke(target, args);
        }
        log.info("Executing {} method : {}", method.getName(), "조회가 아닌 메서드 호출~~~");
        return methodProxy.invoke(target, args);
    }
}
