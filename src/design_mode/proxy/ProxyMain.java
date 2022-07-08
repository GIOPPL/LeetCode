package design_mode.proxy;

import design_mode.proxy.static_proxy.SomeProxyImpl;
import design_mode.proxy.static_proxy.SomeService;

/**
 * Created by GIOPPL
 * on 2022/7/8 20:46
 * TODO:
 */
public class ProxyMain {
    public static void main(String[] args) {
        System.out.println("-----------静态代理-------------");
        SomeService someService=new SomeService();
        SomeProxyImpl someProxy=new SomeProxyImpl(someService);
        someProxy.doSomething();
    }
}
