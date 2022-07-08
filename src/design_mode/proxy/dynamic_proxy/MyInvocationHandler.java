package design_mode.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by GIOPPL
 * on 2022/7/8 22:16
 * TODO:
 */
public class MyInvocationHandler implements InvocationHandler {
    private final Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before。。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("after。。。。");
        return invoke;
    }
}
