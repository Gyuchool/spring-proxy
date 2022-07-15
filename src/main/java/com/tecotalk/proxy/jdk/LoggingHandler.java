package com.tecotalk.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingHandler implements InvocationHandler {

    private final Object target; // 부가기능을 제공할 타깃

    public LoggingHandler(Object target) { //다이나믹 프록시로부터 전달받은 요청을 다시 타깃 오브젝트에
        this.target = target; // 위임해야하므로 타깃 오브젝트를 주입받아둔다.

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            log.info("Executing {} method : {}", method.getName(), "조회 메서드 호출!!!");
        }
        return method.invoke(target, args); // 타깃에게 위임. 모든 인터페이스의 메소드 호출에 적용된다
    }
}
