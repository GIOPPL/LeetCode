package design_mode.proxy.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by GIOPPL
 * on 2022/7/8 21:02
 * TODO:
 */
public class DynamicProxy {
    public static void main(String[] args) {
        IUserService target=new IUserServiceImpl();
        MyInvocationHandler handler=new MyInvocationHandler(target);
        IUserService proxy = (IUserService) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),
                target.getClass().getInterfaces(),handler);
        proxy.doSomething();
    }
}
